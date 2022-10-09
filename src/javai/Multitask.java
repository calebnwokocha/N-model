package javai;

import javai.core.Network;

public class Multitask {
    private int taskCount;
    private Network[] networks;

    public Multitask (Network...networks) {
        this.taskCount = networks.length;
        this.networks = networks;
    }
}
