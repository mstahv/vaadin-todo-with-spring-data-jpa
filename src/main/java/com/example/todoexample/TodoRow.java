package com.example.todoexample;

import com.vaadin.flow.component.HasComponents;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;

public class TodoRow extends HorizontalLayout {

    private final TodoService service;
    Checkbox checked = new Checkbox();
    Span note = new Span();
    Button delete = new Button(VaadinIcon.TRASH.create());

    public TodoRow(TodoService service, TodoEntity todo) {
        this.service = service;
        add(checked, note, delete);
        setAlignItems(Alignment.CENTER);
        /* We are here using low level value change events
         * to sync values from UI fields to DTO. In less
         * trivial apps, see Binder class in Vaadin.
         */
        note.setText(todo.getNote());
        checked.setValue(todo.isChecked());
        checked.addValueChangeListener(e -> {
            todo.setChecked(e.getValue());
            service.updateTodo(todo);
        });
        delete.addThemeVariants(ButtonVariant.LUMO_ICON, ButtonVariant.LUMO_TERTIARY_INLINE);
        delete.addClickListener(e -> {
            service.deleteTodo(todo);
            findAncestor(HasComponents.class).remove(this);
        });
    }
}
