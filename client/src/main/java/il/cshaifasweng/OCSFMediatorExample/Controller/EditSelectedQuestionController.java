package il.cshaifasweng.OCSFMediatorExample.Controller;

import il.cshaifasweng.OCSFMediatorExample.client.*;
import il.cshaifasweng.OCSFMediatorExample.entities.*;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.layout.HBox;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.io.IOException;
import java.util.List;

public class EditSelectedQuestionController
{
    EditSelectedQuestionBoundry editSelectedQuestionBoundry;

    public EditSelectedQuestionController(EditSelectedQuestionBoundry editSelectedQuestionBoundry)
    {
        EventBus.getDefault().register(this);
        this.editSelectedQuestionBoundry = editSelectedQuestionBoundry;
    }
    @Subscribe
    public void handleSelectedQuestion(EditSelectedQuestionEvent editSelectedQuestionEvent)
    {
        Question question = (Question)editSelectedQuestionEvent.getMessage().getBody();
        editSelectedQuestionBoundry.getQuestionTextTXT().setText(question.getQText());
        editSelectedQuestionBoundry.getAnswerA().setText(question.getAnswer1());
        editSelectedQuestionBoundry.getAnswerB().setText(question.getAnswer2());
        editSelectedQuestionBoundry.getAnswerC().setText(question.getAnswer3());
        editSelectedQuestionBoundry.getAnswerD().setText(question.getAnswer4());

    }
    public void showAlertDialog(Alert.AlertType alertType, String title, String message) {
        Platform.runLater(() -> {
            Alert alert = new Alert(alertType);
            alert.setTitle(title);
            alert.setHeaderText(null);
            alert.setContentText(message);
            alert.showAndWait();
        });
    }
    @Subscribe
    public void handleSaveEditedQuestion(SaveEditedQuestionEvent saveEditedQuestionEvent)
    {
        if (saveEditedQuestionEvent.getMessage().getBody() != null)
        {

            Platform.runLater(() -> {
                // Login success
                showAlertDialog(Alert.AlertType.INFORMATION, "Success", "Question Edited and Saved Successfully");
                //EventBus.getDefault().unregister(this);
            });

        }
        else
        {
            Platform.runLater(() -> {
                // Login failure
                showAlertDialog(Alert.AlertType.ERROR, "Error", "One of the Field is not assigned");
                //EventBus.getDefault().unregister(this);
            });
        }
    }
    public void saveQuestion(List<String> question) throws IOException {
        Message message = new Message("saveEditedQuestion", question);
        SimpleClient.getClient().sendToServer(message);
    }

    public void getSubjects() throws IOException {
        Teacher teacher = (Teacher) SimpleClient.getClient().getUser();
        Message message = new Message("getSubjectsForTeacherEQ", teacher);
        SimpleClient.getClient().sendToServer(message);
    }
    @Subscribe
    public void handleGetSubjectForTeacher(GetSubjectsForTeacherEventEQ getSubjectsForTeacherEventEQ)
    {
        List<Subject> subjects = (List<Subject>)getSubjectsForTeacherEventEQ.getMessage().getBody();
        ObservableList<Subject> subjectObservableList= FXCollections.observableArrayList(subjects);
        editSelectedQuestionBoundry.getSelectSubject().setItems(subjectObservableList);
    }

    public void getCourse(Subject selectedItem) throws IOException {
        Message message = new Message("getCoursesForSubjectsEQ", selectedItem);
        SimpleClient.getClient().sendToServer(message);
    }
    private class CourseListCell extends ListCell<Course> {
        private boolean firstRow;

        CourseListCell(boolean firstRow) {
            this.firstRow = firstRow;
        }

        @Override
        protected void updateItem(Course exam, boolean empty) {
            super.updateItem(exam, empty);
            if (empty || exam == null) {
                setText(null);
                setGraphic(null);
            } else {

                Platform.runLater(() -> {
                    HBox container = new HBox();
                    container.setAlignment(Pos.CENTER_LEFT);
                    container.setStyle("-fx-border-width: 0 0 1 0; -fx-border-color: black;");
                    Label examTextLabel2 = new Label(exam.getName());
                    container.getChildren().addAll(examTextLabel2);

                    setGraphic(container);
                });
            }
        }
    }
    @Subscribe
    public void handleGetCoursesForSubject(GetCoursesForSubjectsEventEQ getCoursesForSubjectsEvent)
    {
        List<Course> courses = (List<Course>)getCoursesForSubjectsEvent.getMessage().getBody();
        ObservableList<Course> courseObservableList= FXCollections.observableArrayList(courses);
        editSelectedQuestionBoundry.getCourseList().setItems(courseObservableList);
        editSelectedQuestionBoundry.getCourseList().setCellFactory(param -> {
            return new EditSelectedQuestionController.CourseListCell(false);
        });
    }
}
