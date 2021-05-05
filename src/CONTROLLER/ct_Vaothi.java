package CONTROLLER;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.text.Text;
import jxl.Sheet;
import jxl.Workbook;


import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
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
    private RadioButton rbt_Dapan3;

    @FXML
    private RadioButton rbt_Dapan4;

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

    @FXML
    private Text countDown;

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
        i = Integer.parseInt(st2) - 1;
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
                    rbt_Dapan3.setSelected(true);
                    break;
                case "D":
                    rbt_Dapan4.setSelected(true);
                    break;
                case "Null":
                    rbt_Dapan1.setSelected(false);
                    rbt_Dapan2.setSelected(false);
                    rbt_Dapan3.setSelected(false);
                    rbt_Dapan4.setSelected(false);
                    break;
            }
        }catch (Exception ex){
            rbt_Dapan1.setSelected(false);
            rbt_Dapan2.setSelected(false);
            rbt_Dapan3.setSelected(false);
            rbt_Dapan4.setSelected(false);
        }
    }

    public void updateCauTraLoi(){
        if (!rbt_Dapan1.isSelected() && !rbt_Dapan2.isSelected() && !rbt_Dapan3.isSelected() && !rbt_Dapan4.isSelected()){
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
        if (rbt_Dapan3.isSelected()) {
            CauTraLoi[i] = "C";
//               System.out.println("C");
        }
        if (rbt_Dapan4.isSelected()) {
            CauTraLoi[i] = "D";
//               System.out.println("D");
        }

        lv_dapan.getItems().clear();
        SetListCauTraLoi();
    }

    public void chuyenCauHoi(){
        SetCauHoi(++i, i);
        System.out.println("i = "+i);
        switch (CauTraLoi[i]){
            case "A" :
                rbt_Dapan1.setSelected(true);
                break;
            case "B":
                rbt_Dapan2.setSelected(true);
                break;
            case "C":
                rbt_Dapan3.setSelected(true);
                break;
            case "D":
                rbt_Dapan4.setSelected(true);
                break;
            case "Null":
                rbt_Dapan1.setSelected(false);
                rbt_Dapan2.setSelected(false);
                rbt_Dapan3.setSelected(false);
                rbt_Dapan4.setSelected(false);
                break;
        }
        if (i == 18){
            btn_next.setDisable(true);
            i = 18;
        }
//        System.out.println(i);x1
        if (i > 0){
            btn_previous.setVisible(true);
        }

        lv_dapan.getItems().clear();
        SetListCauTraLoi();
    }

    public void previous(){
        btn_next.setDisable(false);
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
                rbt_Dapan3.setSelected(true);
                break;
            case "D":
                rbt_Dapan4.setSelected(true);
                break;
            case "Null":
                rbt_Dapan1.setSelected(false);
                rbt_Dapan2.setSelected(false);
                rbt_Dapan3.setSelected(false);
                rbt_Dapan4.setSelected(false);
                break;
        }
    }

    public void tinhDiem(){
        int socauchualam = 0;
        for (String b:CauTraLoi){
            if (b.equals("Null")){
                socauchualam+=1;
            }
        }

        if (socauchualam > 0){
            ButtonType foo = new ButtonType("Ok tôi muốn nộp", ButtonBar.ButtonData.OK_DONE);
            ButtonType bar = new ButtonType("Không tôi nhấn nhầm", ButtonBar.ButtonData.CANCEL_CLOSE);
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION,
                    "Bạn còn " + socauchualam + " câu chưa làm, bạn có chắc chắn muốn nộp bài ?",
                    foo, bar);

            alert.setTitle("Xác nhận nộp bài");
            Optional<ButtonType> result = alert.showAndWait();

            if (result.orElse(bar) == foo) {
                for (int h = 1; h < rows; h++) {
                    Sheet sheet = readDataFromSever();
                    DapAn.add(sheet.getCell(9, h).getContents());
                }

//            for (String a:DapAn) {
//                System.out.printf(a);
//            }
//
//            for (String b:CauTraLoi) {
//                System.out.printf(b);
//            }

                System.out.println(DapAn.size());
                System.out.println(CauTraLoi.length);

                for (int j = 0; j < DapAn.size(); j++) {
                    if (CauTraLoi[j].equals(DapAn.get(j))) {
                        diem += 0.5;
                    }
                }

                System.out.println(diem);
                lbl_diem.setVisible(true);
                txt_diem.setVisible(true);
                txt_diem.setText(String.valueOf(diem) + " điểm");
            }
        }
        else {
            ButtonType foo = new ButtonType("Ok tôi muốn nộp", ButtonBar.ButtonData.OK_DONE);
            ButtonType bar = new ButtonType("Không tôi nhấn nhầm", ButtonBar.ButtonData.CANCEL_CLOSE);
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION,
                    "Bạn có chắc chắn muốn nộp bài ?",
                    foo, bar);

            alert.setTitle("Xác nhận nộp bài");
            Optional<ButtonType> result = alert.showAndWait();

            if (result.orElse(bar) == foo) {
                for (int h = 1; h < rows; h++) {
                    Sheet sheet = readDataFromSever();
                    DapAn.add(sheet.getCell(9, h).getContents());
                }

//            for (String a:DapAn) {
//                System.out.printf(a);
//            }
//
//            for (String b:CauTraLoi) {
//                System.out.printf(b);
//            }

                System.out.println(DapAn.size());
                System.out.println(CauTraLoi.length);

                for (int j = 0; j < DapAn.size(); j++) {
                    if (CauTraLoi[j].equals(DapAn.get(j))) {
                        diem += 0.5;
                    }
                }

                System.out.println(diem);
                lbl_diem.setVisible(true);
                txt_diem.setVisible(true);
                txt_diem.setText(String.valueOf(diem) + " điểm");
        }
    }
    }

    public void setTime(){
        try {
            int min = 29, sec = 59;
            for (int b = 0; b < 60; b ++){
                sec = sec - 1;
                Thread.sleep(1000);
                countDown.setText(min + ":" + sec);
                if (sec == 0){
                    min = min - 1;
                    sec = 59;
                }
            }
            thread.interrupt();
        }catch (Exception Ex){
            Ex.printStackTrace();
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
        thread = new Thread(this::setTime);
        thread.start();
    }
}
