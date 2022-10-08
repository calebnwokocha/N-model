package javai;

public class Multitask {
    private int taskCount;
    private Network[] networks;

    public Multitask (Network...networks) {
        this.taskCount = networks.length;
        this.networks = networks;
    }
}
