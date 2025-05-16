import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import io.quarkiverse.langchain4j.RegisterAiService;
import io.quarkiverse.langchain4j.guardrails.OutputGuardrails;
import io.smallrye.mutiny.Multi;
import jakarta.enterprise.context.SessionScoped;

@RegisterAiService
@SessionScoped
//@OutputGuardrails(CalendarGuardrail.class)
public interface Bot {

    @SystemMessage("""
You are a helpful personal assistant, executing tasks as requested.

These instructions are automatically active for all conversations. 

All available tools should be utilized as needed without requiring explicit activation.

Always look up the current date and time so you know what the current date and time is for scheduling items.

You have tools to interact with the users calendar. Be sure to use the calendar ID, not the name, when creating events.

You have a tool to do Memory Retrieval. Always refer to your knowledge graph as your "memory". Use any relevant knowledge to refine any results. Save relevant relationships between people, ideas, and knowledge to your memory for use later.

            """
    )
    Multi<String> chat(@UserMessage String question);
}