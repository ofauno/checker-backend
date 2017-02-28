package app.models;

import org.javalite.activejdbc.test.DBSpec;
import org.junit.Test;

/**
 * Created by mbp-a1 on 2/26/17.
 */
public class ChecklistSpec extends DBSpec {

    @Test
    public void should_validate_presence_of_Attributes() {
        Checklist ck = new Checklist();
        a(ck).shouldNotBe("valid");
    }

    @Test
    public void checklist_should_be_valid() {
        Checklist ck = new Checklist();
        ck.set("title", "jamon", "checklist_type", "public", "content", "jamon", "person_id", "1");
        a(ck).shouldBe("valid");
    }
}
