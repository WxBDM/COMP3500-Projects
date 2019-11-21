
import javax.swing.*;

public class StoreManager {
    public static final String DBMS_SQ_LITE = "SQLite";
    public static final String DB_FILE = "/Users/Brandon/IdeaProjects/COMP3500-Projects/swdesign/data/store.db";

    IDataAdapter adapter = null;
    private static StoreManager instance = null;

    public static StoreManager getInstance() {
        if (instance == null) {

            String dbfile = DB_FILE;
//            JFileChooser fc = new JFileChooser();
//            if (fc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
//                dbfile = fc.getSelectedFile().getAbsolutePath();

            instance = new StoreManager("Network", "localhost:1024");
        }
        return instance;
    }

    private StoreManager(String dbms, String dbfile) {
        if (dbms.equals("Oracle"))
            adapter = new OracleDataAdapter();
        else
        if (dbms.equals("SQLite"))
            adapter = new SQLiteDataAdapter();
        else
        if (dbms.equals("Network"))
            adapter = new NetworkDataAdapter();

        adapter.connect("localhost:1024");
        ProductModel product = adapter.loadProduct(3);

        System.out.println("Loaded product: " + product);

        CustomerModel customer = adapter.loadCustomer(3);
        System.out.println("Loaded customer:" + customer);

    }

    public IDataAdapter getDataAdapter() {
        return adapter;
    }

    public void setDataAdapter(IDataAdapter a) {
        adapter = a;
    }


    public void run() {
        MainUI ui = new MainUI();
        ui.view.setVisible(true);
    }

    public static void main(String[] args) {
        System.out.println("Hello class!");
        StoreManager.getInstance().run();
    }

}
