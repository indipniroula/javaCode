package advancedoop.emailmanagement;

import java.util.Set;

public class EmailDemo {
    public static void main(String[] args) {

        GroupEmailAddr g1 = new GroupEmailAddr("G1");
        g1.addEmail(new IndivEmailAddr("E1"));
        g1.addEmail(new IndivEmailAddr("E2"));


        GroupEmailAddr g2 = new GroupEmailAddr("G2");

        GroupEmailAddr g3 = new GroupEmailAddr("G3");
        g3.addEmail(new IndivEmailAddr("E4"));
        g3.addEmail(new IndivEmailAddr("E5"));

        g2.addEmail(g1);
        g2.addEmail(new IndivEmailAddr("E3"));
        g2.addEmail(g3);
        Set<IndivEmailAddr> g2Targets = g2.getTargets();
        for (IndivEmailAddr e: g2Targets) {
            System.out.println(e);
        }
    }

}
