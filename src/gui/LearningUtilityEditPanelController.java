/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import domain.DomainController;
import domain.learningUtility.LearningUtility;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;

/**
 * FXML Controller class
 *
 * @author Maxim
 */
public class LearningUtilityEditPanelController extends GridPane {

    @FXML
    private TableView<LearningUtility> tableView;
    @FXML
    private Label lblInfo;
    @FXML
    private TextField SearchBar;
    private DomainController domainController;

  public LearningUtilityEditPanelController(DomainController domainController)
{
        this.domainController = domainController;
        initLoader();
} 
  
  
  private void initLoader() throws RuntimeException 
{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("LearningUtilityEditPanel.fxml"));
        loader.setRoot(this);
        loader.setController(this);
        try
        {
            loader.load();
        } catch (IOException e) 
        {
            throw new RuntimeException(e);
        }
        
        try
        {
            setLayoutForTableView();
            tableView.setItems(domainController.getObservableLearningUtilityList());

        }catch(Exception ex)
        {
            lblInfo.setText(ex.getMessage());
        }

    }  
  
  
   private void setLayoutForTableView() throws IOException {
        tableView.setEditable(true);
        
        //Name Column
        TableColumn<LearningUtility, String> colName = new TableColumn("Name");
        colName.setMinWidth(100);
        colName.setCellValueFactory(new PropertyValueFactory<>("Name"));       
        //Description Column
        TableColumn<LearningUtility, String> colDescription = new TableColumn("Omschrijving");
        colDescription.setMinWidth(100);
        colDescription.setCellValueFactory(new PropertyValueFactory<>("Description"));       
         //Price Column
        TableColumn<LearningUtility, BigDecimal> colPrice = new TableColumn("Prijs");
        colPrice.setMinWidth(25);
        colPrice.setCellValueFactory(new PropertyValueFactory<>("Price"));        
         //Loanable Column
        TableColumn<LearningUtility, Boolean> colLoanable = new TableColumn("Uitleenbaar");
        colLoanable.setMinWidth(25);
        colLoanable.setCellValueFactory(new PropertyValueFactory<>("Loanable"));  
         //Article No Column
        TableColumn<LearningUtility, String> colArticleNo = new TableColumn("Artikel Nr.");
        colArticleNo.setMinWidth(50);
        colArticleNo.setCellValueFactory(new PropertyValueFactory<>("ArticleNumber"));  
         //Image Column
        TableColumn<LearningUtility, String> colImage = new TableColumn("Foto");
        colImage.setMinWidth(100);
        colImage.setCellValueFactory(new PropertyValueFactory<>("Picture"));  
         //Location Column
        TableColumn<LearningUtility, String> colLocation = new TableColumn("Locatie");
        colLocation.setMinWidth(100);
        colLocation.setCellValueFactory(new PropertyValueFactory<>("locationId"));      
         //AmountInstock Column
        TableColumn<LearningUtility, Integer> colAmountInstock = new TableColumn("In Stock");
        colAmountInstock.setMinWidth(25);
        colAmountInstock.setCellValueFactory(new PropertyValueFactory<>("amountInCatalog"));       
        //AmountUnavailable Column
        TableColumn<LearningUtility, Integer> colAmountUnavailable = new TableColumn("Onbeschikbaar");
        colAmountUnavailable.setMinWidth(25);
        colAmountUnavailable.setCellValueFactory(new PropertyValueFactory<>("amountUnavailable"));           
        //Company Column
        TableColumn<LearningUtility, Integer> colCompany = new TableColumn("Bedrijf");
        colCompany.setMinWidth(50);
        colCompany.setCellValueFactory(new PropertyValueFactory<>("companyId"));            
        //TargetGroups Column
        TableColumn<LearningUtility, List<String>> colTargetGroups = new TableColumn("Doelgroepen");
        colTargetGroups.setMinWidth(100);
        colTargetGroups.setCellValueFactory(new PropertyValueFactory<>("targetGroupList"));  
        //FieldsOfStudy Column
        TableColumn<LearningUtility, List<String>> colFieldsOfStudy = new TableColumn("Leergebieden");
        colFieldsOfStudy.setMinWidth(100);        
        colFieldsOfStudy.setCellValueFactory(new PropertyValueFactory<>("fieldOfStudyList"));  
        
        tableView.getColumns().addAll(colName,colDescription,colPrice,
                                    colLoanable,colArticleNo,colImage,
                                    colLocation,colAmountInstock,colAmountUnavailable,
                                    colCompany,colTargetGroups,colFieldsOfStudy);
            
     }

    @FXML
    private void SearchForKeywords(KeyEvent event) {
    }
    
}