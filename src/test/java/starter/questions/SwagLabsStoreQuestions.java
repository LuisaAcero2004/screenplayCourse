package starter.questions;

import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import starter.ui.SwagLabsStoreUI;

public class SwagLabsStoreQuestions {

    public static Question<String> ProductsAvailable(){
        return actor -> Text.of(SwagLabsStoreUI.PRODUCTS_TITLE).answeredBy(actor);
    }


}
