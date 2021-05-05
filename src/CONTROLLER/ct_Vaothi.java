package CONTROLLER;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import jxl.Sheet;
import jxl.Workbook;


import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ct_Vaothi implements Initializable {
    @FXML
    private Label txt_cauhoi;

    @FXML
    private Label txt_Dapan1;

    @FXML
    private Label txt_Dapan2;

    @FXML
    private Label txt_Dapan3;

    @FXML
    private Label txt_Dapan4;

    @FXML
    private RadioButton rbt_Dapan1;

    @FXML
    private RadioButton rbt_Dapan2;

    @FXML
    private RadioButton rpt_Dapan3;

    @FXML
    private RadioButton rpt_Dapan4;

    @FXML
    private JFXButton btn_next;

    @FXML
    private JFXButton btn_done;

    @FXML
    private Label lbl_diem;

    @FXML
    private Label txt_diem;

    @FXML
    private JFXButton btn_previous;

    @FXML
    private ToggleGroup dapan;

    @FXML
    private Label lb_CanhBao;

    @FXML
    private JFXListView lv_CauHoi;

    @FXML
    private JFXListView lv_dapan;

    int i = 0;
    float diem=0;
    int rows, cols;
    String[] CauTraLoi = new String[] {
            "Null", "Null", "Null", "Null", "Null", "Null", "Null", "Null", "Null", "Null", "Null", "Null", "Null", "Null",
            "Null", "Null", "Null", "Null", "Null", "Null",
    };
    List<String> DapAn = new ArrayList<>();

    Thread thread;

    public Sheet readDataFromSever(){
        try {
            File file = new File("D:\\Learn\\Code\\Java\\PMTTN\\src\\EXCEL\\Test.xls");
            Workbook wb = Workbook.getWorkbook(file);
            Sheet sheet = wb.getSheet(0);
            rows = sheet.getRows();
            cols = sheet.getColumns();
//            System.out.println(sheet.getCell(2, 1).getContents());
//            System.out.println(rows);
            return sheet;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public void SetCauHoi(int hang, int SoCau){
        Sheet sheet = readDataFromSever();

        txt_cauhoi.setText("Câu " + Integer.valueOf(SoCau+1) + ": " + sheet.getCell(2 , hang+1).getContents());
        txt_Dapan1.setText(sheet.getCell(5 , hang+1).getContents());
        txt_Dapan2.setText(sheet.getCell(6 , hang+1).getContents());
        txt_Dapan3.setText(sheet.getCell(7 , hang+1).getContents());
        txt_Dapan4.setText(sheet.getCell(8 , hang+1).getContents());
    }

    public void SetListCauHoi(){
        for (int i = 1; i < 21; i ++){
            lv_CauHoi.getItems().add("Câu " + i);
        }
    }

    public void SetListCauTraLoi(){
        for (int i = 0  ; i < 20; i ++){
            lv_dapan.getItems().add(CauTraLoi[i]);
        }
    }

    public void getItemFromList(){
        String Items = (String) lv_CauHoi.getSelectionModel().getSelectedItem();
        String str = Items;
        String st2=str.replaceAll("[^0-9]", "");
        SetCauHoi(Integer.parseInt(st2) - 1, Integer.parseInt(st2) - 1);
        int SoCauTraLoi = Integer.parseInt(st2) - 1;
        try{
            switch (CauTraLoi[i]){
                case "A" :
                    rbt_Dapan1.setSelected(true);
                    break;
                case "B":
                    rbt_Dapan2.setSelected(true);
                    break;
                case "C":
                    rpt_Dapan3.setSelected(true);
                    break;
                case "D":
                    rpt_Dapan4.setSelected(true);
                    break;
                case "Null":
                    rbt_Dapan1.setSelected(false);
                    rbt_Dapan2.setSelected(false);
                    rpt_Dapan3.setSelected(false);
                    rpt_Dapan4.setSelected(false);
                    break;
            }
        }catch (Exception ex){
            rbt_Dapan1.setSelected(false);
            rbt_Dapan2.setSelected(false);
            rpt_Dapan3.setSelected(false);
            rpt_Dapan4.setSelected(false);
        }
    }

    public void chuyenCauHoi(){
        if (!rbt_Dapan1.isSelected() && !rbt_Dapan2.isSelected() && !rpt_Dapan3.isSelected() && !rpt_Dapan4.isSelected()){
            CauTraLoi[i] = "Null";
//            System.out.println("Null");
        }

           if (rbt_Dapan1.isSelected()) {
               CauTraLoi[i] = "A";
//               System.out.println("A");
           }
           if (rbt_Dapan2.isSelected()) {
               CauTraLoi[i] = "B";
//               System.out.println("B");
           }
           if (rpt_Dapan3.isSelected()) {
               CauTraLoi[i] = "C";
//               System.out.println("C");
           }
           if (rpt_Dapan4.isSelected()) {
               CauTraLoi[i] = "D";
//               System.out.println("D");
           }

        if (i >= 19){
            btn_done.setVisible(true);
            btn_next.setDisable(true);
            i = 19;
        }
        rbt_Dapan1.setSelected(false);
        rbt_Dapan2.setSelected(false);
        rpt_Dapan3.setSelected(false);
        rpt_Dapan4.setSelected(false);
        SetCauHoi(++i, i);
//        System.out.println(i);
        if (i > 0){
            btn_previous.setVisible(true);
        }

        lv_dapan.getItems().clear();
        SetListCauTraLoi();
    }

    public void previous(){
        SetCauHoi(--i, i);
        if (i == 0){
            btn_previous.setVisible(false);
        }
        System.out.println(i);
//        System.out.println(CauTraLoi.length);
//        System.out.println(CauTraLoi[i]); //
        switch (CauTraLoi[i]){ //
            case "A" :
                rbt_Dapan1.setSelected(true);
                break;
            case "B":
                rbt_Dapan2.setSelected(true);
                break;
            case "C":
                rpt_Dapan3.setSelected(true);
                break;
            case "D":
                rpt_Dapan4.setSelected(true);
                break;
            case "Null":
                rbt_Dapan1.setSelected(false);
                rbt_Dapan2.setSelected(false);
                rpt_Dapan3.setSelected(false);
                rpt_Dapan4.setSelected(false);
                break;
        }
    }

    public void tinhDiem(){
        if (!rbt_Dapan1.isSelected() && !rbt_Dapan2.isSelected() && !rpt_Dapan3.isSelected() && !rpt_Dapan4.isSelected()){
            CauTraLoi[i] = "Null";
//            System.out.println("Null");
        }

        if (rbt_Dapan1.isSelected()) {
            CauTraLoi[i] = "A";
//               System.out.println("A");
        }
        if (rbt_Dapan2.isSelected()) {
            CauTraLoi[i] = "B";
//               System.out.println("B");
        }
        if (rpt_Dapan3.isSelected()) {
            CauTraLoi[i] = "C";
//               System.out.println("C");
        }
        if (rpt_Dapan4.isSelected()) {
            CauTraLoi[i] = "D";
//               System.out.println("D");
        }
        if (i < 20){
            lb_CanhBao.setVisible(true);
        }
        else {
            for (int h = 1; h < rows; h++) {
                Sheet sheet = readDataFromSever();
                DapAn.add(sheet.getCell(9, h).getContents());
            }

            for (String a:DapAn) {
                System.out.printf(a);
            }

            for (String b:CauTraLoi) {
                System.out.printf(b);
            }

            System.out.println(DapAn.size());
            System.out.println(CauTraLoi.length);

            for (int j = 0; j < DapAn.size(); j++) {
                    if (CauTraLoi[j].equals(DapAn.get(j))) {
                    diem += 0.5;
                }
            }

            System.out.println(CauTraLoi.length);
            System.out.println(DapAn.size());

            System.out.println(diem);
            lbl_diem.setVisible(true);
            txt_diem.setVisible(true);
            txt_diem.setText(String.valueOf(diem) + " điểm");
        }
    }

    public void closeCanhBao(){
        lb_CanhBao.setVisible(false);
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        SetCauHoi(0, i);
        SetListCauHoi();
        SetListCauTraLoi();
    }
}
