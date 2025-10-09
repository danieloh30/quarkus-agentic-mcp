import dev.langchain4j.data.message.AiMessage;
import dev.langchain4j.guardrail.OutputGuardrail;
import dev.langchain4j.guardrail.OutputGuardrailResult;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CalendarGuardrail implements OutputGuardrail {

    @Override
    public OutputGuardrailResult validate(AiMessage responseFromLLM) {
        if (!responseFromLLM.text().toLowerCase().contains("ics") &&
            !responseFromLLM.text().toLowerCase().contains("calendar")) {
            return reprompt("No calendar entry created", "Make sure you create an ICS calendar file");
        }
        return success();
    }

}
