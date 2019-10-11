import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class AddProductController {
    AddbuttonListener addButtonListener = new AddbuttonListener();
    CancelbuttonListener cancelButtonListener = new CancelbuttonListener();

}

class AddbuttonListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        JOpetionPane.showMessageDialog(null, "You click on Add");
    }
}