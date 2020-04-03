import com.epam.homeTask2.logic.TaskLogic;
import com.epam.homeTask2.logic.TaskLogicService;
import com.epam.homeTask2.parseredText.Text;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

public class TestSecondTask {
     static Text txt;
     static String text = null;
     static TaskLogic taskLogic;
    @BeforeClass
    public static void initData() {
        text = "Hello. My name is Vlad.\nIm the CODER!";
        txt = new Text(text);
        taskLogic = new TaskLogicService();
    }
    @Test
    public void shouldRecoverText(){
        assertEquals(text, txt.recoverText());
    }
    @Test
    public void shouldReturnSortedMessages(){
        List<String> list = new ArrayList<>(List.of("My name is Vlad.","Im the CODER!", "Hello."));
        assertEquals(list, taskLogic.doTaskLogic(txt));
    }
}
