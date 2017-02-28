package app.controllers;

import app.models.Checklist;
import app.models.Person;
import app.util.JsonHelper;
import org.javalite.activejdbc.LazyList;
import org.javalite.activeweb.annotations.OPTIONS;
import org.javalite.activeweb.annotations.RESTful;
import org.javalite.common.Util;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Created by mbp-a1 on 2/26/17.
 */
@RESTful
@SuppressWarnings("unchecked")
public class ChecklistController extends APIController {

    @OPTIONS
    public void index() {
        LazyList<Checklist> cs = Checklist.findAll()
                .include(Person.class)
                .orderBy("id");

        assign("checklist", cs);
        render().header("Access-Control-Allow-Origin", "*")
                .contentType("application/json");
    }

    public void show() {
        List<Checklist> cs = Checklist
                .where("id = ?", getId())
                .include(Person.class);

        if (cs.size() == 0) {
            //catch by filter
            throw new RuntimeException("could not find person with id: " + getId());
        }

        assign("checklist", cs.get(0));
        render("_checklist"); // unusual use of a partial - we are doing it for reuse
    }

    public void update() throws IOException {
        Checklist myChecklist = Checklist.findById(getId());
        myChecklist.set(
                "title", param("title"),
                "content", param("content"),
                "checklist_type", param("type")).saveIt();

        String msg = "successfully updated checklist: " + getId() + " - " + params().toString();
        view("message", msg, "code", 200);
        render("message");
    }

    public void destroy() {
        view("checklist", Checklist.findAll().include(Person.class).orderBy("id"));
        render().contentType("application/json");
    }

    public void create() throws IOException {
        Map[] cs = JsonHelper.toMaps(Util.read(getRequestInputStream()));

        Person me = Person.findById(3);

        for (Map checklists : cs) {
            Checklist list2create = new Checklist();
            list2create.fromMap(checklists);
            list2create.saveIt();
            me.add(list2create);
        }

        view("message", "successfully created checklist", "code", 200);
        render("message");
    }
}
