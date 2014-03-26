package templating.velocity.domain;

import java.util.ArrayList;
import java.util.List;

public class Contact {
    private List<String> listeTelephone = new ArrayList<String>();

    public List<String> getListeTelephone() {
        return listeTelephone;
    }

    public void setListeTelephone(List<String> listeTelephone) {
        this.listeTelephone = listeTelephone;
    }
}
