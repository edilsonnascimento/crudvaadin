package br.edu.utfpr.crudvaadin.views;

import br.edu.utfpr.crudvaadin.data.form.ClienteForm;
import br.edu.utfpr.crudvaadin.data.model.Cliente;
import br.edu.utfpr.crudvaadin.data.service.ClienteRepository;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.PWA;
import org.springframework.beans.factory.annotation.Autowired;

@Route
@PWA(name = "Exemplo de CRUD",
        shortName = "CRUD App",
        description = "Este é um exemplo de CRUD completo.",
        enableInstallPrompt = false)
public class MainView extends VerticalLayout {

    private final ClienteRepository repository;
    private Grid<Cliente> grid = new Grid<>(Cliente.class);
    private TextField filterText = new TextField();
    Button novoBtn = new Button("Novo cliente");

    private ClienteForm form;

    public MainView(@Autowired ClienteRepository repository) {
        this.repository = repository;

        form = new ClienteForm(this, repository);
        form.setCliente(null);

        grid.setColumns("primeiroNome", "sobrenome", "status");
        grid.setSizeFull();
        grid.asSingleSelect().addValueChangeListener(e -> selecionar());
        atualizarLista();

        filterText.setPlaceholder("Filtrar por nome...");
        filterText.setClearButtonVisible(true);
        filterText.setValueChangeMode(ValueChangeMode.EAGER);
        filterText.addValueChangeListener(e -> atualizarLista());

        novoBtn.addClickListener(e -> adicionarNovo());

        HorizontalLayout mainContent = new HorizontalLayout(grid, form);
        mainContent.setSizeFull();
        add(new HorizontalLayout(filterText, novoBtn), mainContent);
        setSizeFull();
    }

    public void atualizarLista() {
        if (filterText.getValue().isEmpty()) {
            grid.setItems(repository.findAll());
        } else {
            grid.setItems(repository.findByNome(filterText.getValue()));
        }
    }

    public void selecionar() {
        form.setCliente(grid.asSingleSelect().getValue());
    }

    private void adicionarNovo() {
        grid.asSingleSelect().clear();
        form.setCliente(new Cliente());
    }

}
