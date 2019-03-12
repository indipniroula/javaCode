package advancedoop.emailmanagement;

import java.util.HashSet;
import java.util.Set;

public class GroupEmailAddr extends EmailAddr {

    private String identifier;
    private Set<EmailAddr> allAddresses;

    public GroupEmailAddr(String identifier) {
        this.identifier = identifier;
        this.allAddresses = new HashSet<>();
    }

    public Set<IndivEmailAddr> getTargets() {
       Set<IndivEmailAddr> result = new HashSet<>();
       for (EmailAddr e : allAddresses) {
           if (e.isGroupEmail()) {
               result.addAll((((GroupEmailAddr) e).getTargets()));
           } else {
               result.add((IndivEmailAddr) e);
           }
       }
       return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof GroupEmailAddr)) {
            return false;
        }
        return identifier.equals(((GroupEmailAddr) obj).identifier);
    }

    @Override
    public String toString() {
        return identifier;
    }

    @Override
    public int hashCode() {
        return identifier.hashCode();
    }

    public void addEmail(EmailAddr e) {
        allAddresses.add(e);
    }


    @Override
    boolean isIndivEmail() {
        return false;
    }

    @Override
    boolean isGroupEmail() {
        return true;
    }
}
