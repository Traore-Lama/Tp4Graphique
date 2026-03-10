package sio.tp4;

import javafx.collections.FXCollections;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import sio.tp4.models.Agent;
import sio.tp4.models.Client;
import sio.tp4.models.Releve;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class TP4Controller implements Initializable {

    private ArrayList<Agent> agents;
    private Alert alert;

    @FXML
    private TableColumn tcNumeroAgent;
    @FXML
    private TextField txtConsommation;
    @FXML
    private TableColumn tcNomClient;
    @FXML
    private Button btnInserer;
    @FXML
    private TableColumn tcNumeroClient;
    @FXML
    private TableView tvReleves;
    @FXML
    private TableColumn tcValeurReleve;
    @FXML
    private TableColumn tcDateReleve;
    @FXML
    private TableView<Client> tvClients;
    @FXML
    private TableColumn tcNomAgent;
    @FXML
    private DatePicker dpDateReleve;
    @FXML
    private TextField txtNouveauReleve;
    @FXML
    private TableView<Agent> tvAgents;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        agents = new ArrayList<>();
        initDatas();
        alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Information");
        alert.setHeaderText(null);

        // Les Colones des agents
        tcNumeroAgent.setCellValueFactory(new PropertyValueFactory<>("numero"));
        tcNomAgent.setCellValueFactory(new PropertyValueFactory<>("nom"));

        // Les Colones des clients
        tcNumeroClient.setCellValueFactory(new PropertyValueFactory<>("numero"));
        tcNomClient.setCellValueFactory(new PropertyValueFactory<>("nom"));

        // Les Colones des Releve
        tcDateReleve.setCellValueFactory(new PropertyValueFactory<>("date"));
        tcValeurReleve.setCellValueFactory(new PropertyValueFactory<>("valeurReleve"));
        tvAgents.setItems(FXCollections.observableList(agents));



    }

    public void initDatas()
    {
        // 2 agents
        Agent agent1 = new Agent("Lama",1);
        Agent agent2 = new Agent("Bishoy",2);

        // 3 clients
        Client client1 = new Client("Stanley",1);
        Client client2 = new Client("Mael",2);
        Client client3 = new Client("Koussai",3);

        // 5 releves
        Releve releve1 = new Releve("28/12/2025", 600);
        Releve releve2 = new Releve("03/01/2026", 1000);
        Releve releve3 = new Releve("05/02/2026", 1200);
        Releve releve4 = new Releve("20/04/2026", 550);
        Releve releve5 = new Releve("09/05/2026", 2800);

        client1.addReleve(releve1);
        client1.addReleve(releve2);
        client1.addReleve(releve3);

        client2.addReleve(releve4);
        client2.addReleve(releve5);

        agent1.addClient(client1);
        agent1.addClient(client3);
        agent2.addClient(client2);

        agents.add(agent1);
        agents.add(agent2);

    }

    @FXML
    public void tvClientsClicked(Event event)
    {
        tvReleves.setItems(FXCollections.observableList(tvClients.getSelectionModel().getSelectedItem().getReleves()));
        txtConsommation.setText(String.valueOf(tvClients.getSelectionModel().getSelectedItem().calculConso()));
    }

    @FXML
    public void btnInsererClicked(Event event)
    {

        if (tvClients.getSelectionModel().getSelectedItem() == null)
        {
            alert.setContentText("Veuillez entrer un nouveau Client");
            alert.show();
        }
        else if (txtNouveauReleve.getText().isEmpty())
        {
            alert.setContentText("Entrer un releve");
            alert.show();

        }
        else if (tvClients.getSelectionModel().getSelectedItem().verifValeur(Integer.parseInt(txtNouveauReleve.getText())))
        {
            alert.setContentText("Valeur trop petite");
            alert.show();
        }
        else
        {

        }
    }

    @FXML
    public void tvAgentsClicked(Event event)
    {
        tvClients.setItems(FXCollections.observableList(tvAgents.getSelectionModel().getSelectedItem().getClients()));

    }
}