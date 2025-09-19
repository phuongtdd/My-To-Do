package spring.todoapp.modal;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Label {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "label_id")
    private String labelId;

    @Column(name = "label_name")
    private String labelName;

    @ManyToMany(mappedBy = "labels")
    private List<Task> tasks;

    public Label() {}

    public Label(String labelName) {}

    @Override
    public String toString() {
        return "Label{" +
                "labelId='" + labelId + '\'' +
                ", labelName='" + labelName + '\'' +
                ", tasks=" + tasks +
                '}';
    }
}
