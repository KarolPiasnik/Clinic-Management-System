package gui;



public class WorkerAdminPanel extends PersonAdminPanel {
    public WorkerAdminPanel() {
        super();
        collection = dataBase.getWorkers();
    }
}
