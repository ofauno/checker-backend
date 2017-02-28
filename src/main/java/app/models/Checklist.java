package app.models;

import org.javalite.activejdbc.Model;
import org.javalite.activejdbc.annotations.BelongsTo;

import java.util.List;

/**
 * Created by mbp-a1 on 2/26/17.
 */
@BelongsTo(parent = Person.class, foreignKeyName = "person_id")
public class Checklist extends Model {
    static {
        validatePresenceOf("title", "content", "checklist_type");
    }

    public List<Person> getPerson(){
        return getAll(Person.class);
    }
}
