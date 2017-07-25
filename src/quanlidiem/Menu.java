package quanlidiem;

import java.util.Vector;

public interface Menu {
    public static final Vector<String> mChon = new Vector<String>();
    public void display();
    public int getSelected();
    public void execute(int n);
    public void run();
}
