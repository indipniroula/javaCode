package advancedoop.emailmanagement;

import java.util.HashSet;
import java.util.Set;

public class IndivEmailAddr extends EmailAddr {
    private String identifier;

    public IndivEmailAddr(String identifier) {
        this.identifier = identifier;
    }

    @Override
    public String toString() {
        return identifier;
    }

    public Set<IndivEmailAddr> getTargets() {
        return new HashSet<>(Set.of(this));
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof IndivEmailAddr)) {
            return false;
        }
        return identifier.equals(((IndivEmailAddr) obj).identifier);
    }

    @Override
    public int hashCode() {
        return identifier.hashCode();
    }

    @Override
    boolean isIndivEmail() {
        return true;
    }

    @Override
    boolean isGroupEmail() {
        return false;
    }
}
