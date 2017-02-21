import javax.swing.*;
import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;
import java.util.ArrayList;

/**
 * Created by mdebiase on 2/8/2017.
 */
public class EmployeeListModel implements ListModel{

    private ArrayList<Employee> EmployeeList;
    private ArrayList<ListDataListener> ListenerList;

    public EmployeeListModel(){

        // Create Container for list
        this.EmployeeList = new ArrayList<>();
        this.ListenerList = new ArrayList<>();

    }

    @Override
    public int getSize() {
        return this.EmployeeList.size();
    }

    @Override
    public Object getElementAt(int index) {
        return this.EmployeeList.get(index);
    }

    public int addEmployee(Employee e){
        this.EmployeeList.add(e);
        this.announce();
        return this.getSize();
    }

    public int removeEmployee(Employee e){
        this.EmployeeList.remove(e);
        this.announce();
        return this.getSize();
    }

    public int removeEmployee(int index){
        this.EmployeeList.remove(index);
        this.announce();
        return this.getSize();
    }

    public void updateEmployeeAt(Employee e, int index){
        this.EmployeeList.set(index, e);
        this.announce();
    }



    @Override
    public void addListDataListener(ListDataListener l) {
        this.ListenerList.add(l);
    }

    @Override
    public void removeListDataListener(ListDataListener l) {
        this.ListenerList.remove(l);
    }

    private void announce(){
        ListDataEvent event = new ListDataEvent(this, ListDataEvent.CONTENTS_CHANGED, 0, this.getSize());
        for (ListDataListener listener : this.ListenerList){
            listener.contentsChanged(event);
        }
    }
}
