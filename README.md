# Quarkus Agentic MCP Demo

This project demonstrates an intelligent agentic application built with [Quarkus](https://quarkus.io/), the Supersonic Subatomic Java Framework, and the [Model Context Protocol (MCP)](https://modelcontextprotocol.io/). It integrates multiple MCP servers with Quarkus and LangChain4j to create a powerful AI assistant capable of web search, location services, file management, and team collaboration.

## 🌟 Why Build Agentic AI Apps with Java, Quarkus & MCP?

### The Power of Java for Enterprise AI

**Java remains the backbone of enterprise applications**, and now it's perfectly positioned for the AI revolution:

- **🏢 Enterprise-Ready**: Leverage Java's mature ecosystem, proven reliability, and extensive tooling that enterprises trust
- **🔒 Type Safety & Security**: Strong typing catches errors at compile-time, crucial for production AI systems
- **⚡ Performance**: Quarkus delivers sub-second startup times and minimal memory footprint—ideal for cloud-native AI deployments
- **🔄 Seamless Integration**: Connect AI capabilities to existing Java microservices, databases, and enterprise systems without friction
- **👥 Developer Talent**: Tap into the world's largest developer community (9M+ Java developers) for AI projects

### Why Quarkus for AI Applications?

**Quarkus is the modern Java framework built for cloud-native AI workloads:**

- **⚡ Lightning Fast**: ~0.1s startup time in native mode vs. traditional Java frameworks
- **💾 Memory Efficient**: Uses 10x less memory than traditional Java stacks—critical for cost-effective AI deployments
- **🔥 Live Coding**: Instant hot-reload during development—see AI behavior changes immediately
- **📊 Built-in Observability**: OpenTelemetry integration out-of-the-box for monitoring AI agent decisions
- **🐳 Container-First**: Optimized for Kubernetes, Docker, and serverless platforms
- **🎯 Developer Joy**: Unified configuration, dev UI, and extensions make AI development productive

### The MCP Advantage

**Model Context Protocol (MCP) is the game-changer for building agentic AI:**

- **🔌 Standardized Tool Integration**: Connect to any service (Slack, Google Maps, filesystems) through a unified protocol
- **🧩 Composable Architecture**: Mix and match MCP servers like building blocks—no custom integration code
- **🔄 Reusable Components**: MCP servers work across different AI models and frameworks
- **🚀 Rapid Development**: Add new capabilities by simply configuring MCP servers, not writing integration code
- **🌐 Growing Ecosystem**: Leverage community-built MCP servers for common tasks
- **🎭 Multi-Agent Ready**: Coordinate multiple AI agents with shared context and tools

### What This Demo Proves

This application showcases the **perfect synergy** of Java, Quarkus, and MCP:

✅ **Production-Grade AI**: Build enterprise-ready agentic systems with Java's reliability
✅ **Cloud-Native Performance**: Deploy AI agents that start in milliseconds and scale efficiently
✅ **Rapid Prototyping**: Go from idea to working AI agent in minutes with live coding
✅ **Real-World Integration**: Connect AI to actual services (Slack, Google Maps, filesystems)
✅ **Observable & Debuggable**: Full visibility into AI decision-making with built-in telemetry
✅ **Future-Proof**: Built on open standards (MCP) and modern Java (Quarkus)

### Real-World Use Cases

This architecture enables powerful enterprise AI scenarios:

- **🤖 Intelligent Assistants**: Build chatbots that can search the web, access databases, and take actions
- **📊 Data Analysis Agents**: Create AI that reads files, queries APIs, and generates reports
- **🔄 Workflow Automation**: Develop agents that coordinate across multiple systems (CRM, email, calendars)
- **🎯 Customer Support**: Deploy AI that accesses knowledge bases, creates tickets, and escalates issues
- **📈 Business Intelligence**: Build agents that gather data from multiple sources and provide insights

**Bottom Line**: If you're building AI applications for the enterprise, Java + Quarkus + MCP gives you the performance of Python frameworks with the reliability and ecosystem of Java.

---

## 📋 Table of Contents

- [Overview](#overview)
- [Prerequisites](#prerequisites)
- [Installation & Setup](#installation--setup)
- [Running the Application](#running-the-application)
- [Testing the Application](#testing-the-application)
- [Packaging & Deployment](#packaging--deployment)
- [Troubleshooting](#troubleshooting)
- [Additional Resources](#additional-resources)

## 🎯 Overview

This application showcases:
- **AI-powered agent reasoning** using OpenAI's GPT models
- **Multiple MCP server integrations**: Brave Search, Google Maps, Slack, filesystem, memory, and time
- **Real-time chat interface** via WebSocket
- **Built-in observability** with OpenTelemetry, Grafana, and LGTM stack
- **Live coding** with Quarkus Dev Mode

## ⚙️ Prerequisites

Before running this application, ensure you have the following installed:

### Required Software

1. **Java 21 or later**
   - Check version: `java -version`
   - Recommended: Use [SDKMAN!](https://sdkman.io/) to manage Java versions
   - This project uses Java 21 (see `.sdkmanrc`)
   ```bash
   # Install SDKMAN (if not already installed)
   curl -s "https://get.sdkman.io" | bash
   
   # Install Java 21
   sdk install java 21.0.2-tem
   sdk use java 21.0.2-tem
   ```

2. **Maven 3.9+**
   - Check version: `./mvnw --version`
   - Maven wrapper (`mvnw`) is included in the project

3. **Node.js and npm**
   - Required for MCP server processes
   - Check versions: `node --version` and `npm --version`
   - Recommended: Node.js 18+ and npm 9+
   - Install from [nodejs.org](https://nodejs.org/en/download) or use [nvm](https://github.com/nvm-sh/nvm)
   ```bash
   # Using nvm (recommended)
   nvm install --lts
   nvm use --lts
   ```

4. **Python 3.8+** (for time MCP server)
   - Check version: `python3 --version`
   - Install the MCP time server:
   ```bash
   pip3 install mcp-server-time
   ```

5. **Container Runtime** (Optional but recommended)
   - Docker Desktop, Podman, or similar
   - Required for built-in telemetry/observability features (Grafana, LGTM stack)
   - If unavailable, see [Disabling Telemetry](#disabling-telemetry)

### API Keys

You'll need API keys for the following services:

| Service | Purpose | Get API Key |
|---------|---------|-------------|
| **OpenAI** | LLM chat model (GPT-4o-mini) | [platform.openai.com](https://platform.openai.com/docs/quickstart) |
| **Brave Search** | Web search capabilities | [brave.com/search/api](https://brave.com/search/api/) |
| **Google Maps** | Location and directions | [Google Maps API](https://developers.google.com/maps/documentation/javascript/get-api-key#create-api-keys) |
| **Slack** | Team messaging integration | [Slack MCP Setup](https://github.com/modelcontextprotocol/servers/tree/main/src/slack#setup) |

**Note for Slack**: You need both a _Bot User OAuth Token_ (starts with `xoxb-`) and your _Team ID_. Follow the [setup instructions](https://github.com/modelcontextprotocol/servers/tree/main/src/slack#setup) to create a Slack app and obtain these credentials.

## 🚀 Installation & Setup

### 1. Clone the Repository

```bash
git clone <repository-url>
cd quarkus-agentic-mcp
```

### 2. Create the Playground Directory

The filesystem MCP server requires a `playground` directory:

```bash
mkdir -p playground
```

Optionally, create a sample team file:

```bash
mkdir -p playground/calendar
echo "Daniel Oh - Likes Italian food" > playground/team.txt
echo "Colleague - Gluten-free diet" >> playground/team.txt
```

### 3. Configure API Keys

Create a `.env` file in the project root directory (this file is already in `.gitignore`):

```bash
touch .env
```

Add your API keys to the `.env` file:

```properties
# OpenAI Configuration
quarkus.langchain4j.openai.api-key=sk-proj-xxxxxxxxxxxxxxxxxxxxx

# Brave Search API Key
quarkus.langchain4j.mcp.bravesearch.environment.BRAVE_API_KEY=BSAxxxxxxxxxxxxxxxxxxxxx

# Google Maps API Key
quarkus.langchain4j.mcp.googlemaps.environment.GOOGLE_MAPS_API_KEY=AIzaxxxxxxxxxxxxxxxxxxxxx

# Slack Configuration
quarkus.langchain4j.mcp.slack.environment.SLACK_BOT_TOKEN=xoxb-xxxxxxxxxxxxxxxxxxxxx
quarkus.langchain4j.mcp.slack.environment.SLACK_TEAM_ID=Txxxxxxxxxxxxx
```

**⚠️ Security Warning**: Never commit the `.env` file to version control. For production deployments, use secure secret management solutions like HashiCorp Vault, Kubernetes Secrets, or cloud provider secret managers.

### 4. Verify MCP Server Dependencies

The application will automatically download MCP server packages via npm when started. To verify npm can access these packages:

```bash
# Test npm access
npm view @modelcontextprotocol/server-filesystem version
npm view @modelcontextprotocol/server-memory version
npm view @modelcontextprotocol/server-brave-search version
npm view @modelcontextprotocol/server-google-maps version
npm view @modelcontextprotocol/server-slack version
```

### 5. Disabling Telemetry (Optional)

If you don't have a container runtime available, disable telemetry by commenting out these lines in `src/main/resources/application.properties`:

```properties
# Comment out these lines if no container runtime is available:
# %dev.quarkus.otel.exporter.otlp.traces.endpoint=http://localhost:4317
# %dev.quarkus.otel.exporter.otlp.traces.headers=authorization=Bearer my_secret
# %dev.quarkus.datasource.jdbc.telemetry=true
# %dev.quarkus.otel.logs.enabled=true
# %dev.quarkus.otel.traces.enabled=true
```

Or set this in your `.env` file:

```properties
quarkus.observability.enabled=false
```

## 🏃 Running the Application

### Development Mode (Recommended)

Start the application in development mode with live reload:

```bash
./mvnw compile quarkus:dev
```

**What happens during startup:**
- Maven compiles the Java code
- Quarkus starts the application on port 8080
- MCP servers are launched automatically via npm/python
- Dev Services (like LGTM stack) start in containers (if available)
- Live reload is enabled for instant code changes

**Access Points:**
- **Main Application**: http://localhost:8080
- **Dev UI**: http://localhost:8080/q/dev/
- **Grafana** (if telemetry enabled): Available via Dev UI → Observability

### First-Time Startup

The first run may take longer as it:
1. Downloads Maven dependencies
2. Downloads npm packages for MCP servers
3. Starts Dev Services containers
4. Compiles the application

Subsequent starts will be much faster.

### Verifying the Application is Running

You should see output similar to:

```
__  ____  __  _____   ___  __ ____  ______
 --/ __ \/ / / / _ | / _ \/ //_/ / / / __/
 -/ /_/ / /_/ / __ |/ , _/ ,< / /_/ /\ \
--\___\_\____/_/ |_/_/|_/_/|_|\____/___/
INFO  [io.quarkus] (Quarkus Main Thread) research 1.0-SNAPSHOT on JVM (powered by Quarkus 3.36.0) started in 3.456s. Listening on: http://localhost:8080
INFO  [io.quarkus] (Quarkus Main Thread) Profile dev activated. Live Coding activated.
INFO  [io.quarkus] (Quarkus Main Thread) Installed features: [cdi, langchain4j-mcp, langchain4j-openai, ...]
```

## 🧪 Testing the Application

### Web Interface

Once the application is running, open your browser to http://localhost:8080. You'll see a chat interface where you can interact with the AI assistant.

### Sample Prompts

Try these prompts to see the agent reasoning and tool usage in action:

#### Complex Multi-Step Task

```
My name is Daniel Oh. I am a member of a team of 2. I like Italian food, while my colleague is on a strict gluten-free diet.

Please find one good restaurant in Boston, MA with the highest rating that meets the team's dietary needs and preferences.
Then, invite the team to a lunch at 12pm next Friday. In your message, include the name and description of the restaurant,
the time and date of the lunch, and driving directions from Back Bay, Boston.
```

**What this demonstrates:**
- Reading team information from `playground/team.txt` (filesystem MCP)
- Web search for restaurants (Brave Search MCP)
- Location and directions lookup (Google Maps MCP)
- Date/time calculations (Time MCP)
- Memory of conversation context (Memory MCP)

#### Follow-up Tasks

After the initial prompt, try these follow-ups:

```
Send the restaurant recommendation details to the slack channel "#lunchtime".
```

```
Create an ICS calendar file for me in my calendar in the "playground/calendar" directory.
```

#### Reasoning and Reflection Prompts

```
What was the reasoning you used to arrive at that recommendation?
```

```
How did you choose the restaurant?
```

```
What actions did you take for each step and which tools did you use?
```

```
Why did you search for gluten-free restaurants?
```

```
What do you remember about each person on the team based on team.txt file?
```

### Using the Dev UI

The Quarkus Dev UI provides additional testing capabilities:

1. Navigate to http://localhost:8080/q/dev/
2. Go to **Extensions** → **LangChain4j** → **Chat**
3. You'll see the system message pre-filled from [Bot.java](src/main/java/Bot.java)
4. Start chatting with the AI assistant

**Dev UI Features:**
- View all available MCP tools
- Monitor request/response logs
- Access Grafana dashboards (if telemetry enabled)
- Hot reload code changes
- View application metrics

### Observability

If you have telemetry enabled (container runtime available):

1. Go to Dev UI → **Observability**
2. Click on **Grafana** link
3. Explore traces, logs, and metrics
4. View LLM request/response details
5. Monitor MCP server interactions

## 📦 Packaging & Deployment

### Standard JVM Package

Build a standard JVM package:

```bash
./mvnw package
```

This creates `target/quarkus-app/quarkus-run.jar` along with dependencies in `target/quarkus-app/lib/`.

**Run the packaged application:**

```bash
# Ensure API keys are set as environment variables
export OPENAI_API_KEY="your-key-here"
export BRAVE_API_KEY="your-key-here"
export GOOGLE_MAPS_API_KEY="your-key-here"
export SLACK_BOT_TOKEN="your-token-here"
export SLACK_TEAM_ID="your-team-id"

# Run the application
java -jar target/quarkus-app/quarkus-run.jar
```

### Uber JAR Package

Build a single executable JAR with all dependencies:

```bash
./mvnw package -Dquarkus.package.type=uber-jar
```

**Run the uber JAR:**

```bash
java -jar target/research-1.0-SNAPSHOT-runner.jar
```

### Native Executable

Build a native executable for faster startup and lower memory footprint:

**Option 1: With GraalVM installed locally**

```bash
# Ensure GraalVM is installed and GRAALVM_HOME is set
./mvnw package -Dnative
```

**Option 2: Using container build (recommended)**

```bash
# No GraalVM installation required
./mvnw package -Dnative -Dquarkus.native.container-build=true
```

**Run the native executable:**

```bash
# Set environment variables
export OPENAI_API_KEY="your-key-here"
# ... (other API keys)

# Run
./target/research-1.0-SNAPSHOT-runner
```

**Native Build Benefits:**
- ⚡ Startup time: ~0.1s (vs ~3s for JVM)
- 💾 Memory usage: ~50MB (vs ~200MB for JVM)
- 📦 Single executable binary
- 🚀 Ideal for containers and serverless

**Note**: Native builds take longer (5-10 minutes) but result in highly optimized executables.

### Container Deployment

Build a container image:

```bash
# Using Docker
docker build -f src/main/docker/Dockerfile.jvm -t quarkus-agentic-mcp:jvm .

# Or for native
docker build -f src/main/docker/Dockerfile.native -t quarkus-agentic-mcp:native .
```

**Run the container:**

```bash
docker run -i --rm -p 8080:8080 \
  -e OPENAI_API_KEY="your-key" \
  -e BRAVE_API_KEY="your-key" \
  -e GOOGLE_MAPS_API_KEY="your-key" \
  -e SLACK_BOT_TOKEN="your-token" \
  -e SLACK_TEAM_ID="your-team-id" \
  quarkus-agentic-mcp:jvm
```

## 🔧 Troubleshooting

### Common Issues

#### 1. "Cannot find node or npm"

**Problem**: MCP servers fail to start because Node.js/npm is not found.

**Solution**:
```bash
# Verify installation
node --version
npm --version

# If not installed, install Node.js
# macOS (using Homebrew)
brew install node

# Linux (using nvm)
curl -o- https://raw.githubusercontent.com/nvm-sh/nvm/v0.39.0/install.sh | bash
nvm install --lts
```

#### 2. "Python3 not found" or Time MCP Server Fails

**Problem**: The time MCP server requires Python 3.

**Solution**:
```bash
# Install Python 3
# macOS
brew install python3

# Install the MCP time server
pip3 install mcp-server-time

# Verify
python3 --version
python3 -m mcp_server_time --help
```

#### 3. API Key Errors

**Problem**: "Unauthorized" or "Invalid API key" errors.

**Solution**:
- Verify your `.env` file exists and contains valid keys
- Check that keys don't have extra spaces or quotes
- Ensure the `.env` file is in the project root directory
- Restart the application after updating `.env`

#### 4. Port 8080 Already in Use

**Problem**: Another application is using port 8080.

**Solution**:
```bash
# Find what's using the port
lsof -i :8080

# Kill the process or change Quarkus port
# Add to .env:
quarkus.http.port=8081
```

#### 5. Container/Docker Issues

**Problem**: Telemetry features fail to start.

**Solution**:
- Ensure Docker/Podman is running: `docker ps`
- Or disable telemetry (see [Disabling Telemetry](#disabling-telemetry))

#### 6. MCP Server Connection Failures

**Problem**: "Failed to connect to MCP server" errors.

**Solution**:
```bash
# Test npm package access
npm view @modelcontextprotocol/server-filesystem

# Clear npm cache if needed
npm cache clean --force

# Verify playground directory exists
ls -la playground/
```

#### 7. Out of Memory Errors

**Problem**: Application crashes with OutOfMemoryError.

**Solution**:
```bash
# Increase JVM heap size
./mvnw compile quarkus:dev -Djvm.args="-Xmx2g"
```

### Debug Mode

Enable detailed logging for troubleshooting:

Add to `.env`:
```properties
quarkus.log.level=DEBUG
quarkus.log.category."io.quarkiverse.langchain4j".level=DEBUG
quarkus.log.category."dev.langchain4j".level=DEBUG
```

### Getting Help

- **Quarkus Documentation**: https://quarkus.io/guides/
- **LangChain4j Quarkus**: https://docs.quarkiverse.io/quarkus-langchain4j/dev/
- **MCP Documentation**: https://modelcontextprotocol.io/
- **GitHub Issues**: Report bugs or ask questions in the repository

## 📚 Additional Resources

### Documentation

- **Quarkus**: https://quarkus.io/
- **LangChain4j**: https://docs.langchain4j.dev/
- **Model Context Protocol**: https://modelcontextprotocol.io/
- **OpenAI API**: https://platform.openai.com/docs/

### Key Technologies

- **Quarkus LangChain4j MCP Extension** ([guide](https://docs.quarkiverse.io/quarkus-langchain4j/dev/index.html)): MCP client implementation
- **Quarkus LangChain4j OpenAI** ([guide](https://docs.quarkiverse.io/quarkus-langchain4j/dev/index.html)): OpenAI integration
- **Quarkus WebSockets**: Real-time communication
- **Quarkus OpenTelemetry**: Observability and tracing

### MCP Servers Used

| Server | Purpose | Documentation |
|--------|---------|---------------|
| **filesystem** | File operations | [npm](https://www.npmjs.com/package/@modelcontextprotocol/server-filesystem) |
| **memory** | Conversation memory | [npm](https://www.npmjs.com/package/@modelcontextprotocol/server-memory) |
| **brave-search** | Web search | [npm](https://www.npmjs.com/package/@modelcontextprotocol/server-brave-search) |
| **google-maps** | Location services | [npm](https://www.npmjs.com/package/@modelcontextprotocol/server-google-maps) |
| **slack** | Team messaging | [npm](https://www.npmjs.com/package/@modelcontextprotocol/server-slack) |
| **time** | Date/time operations | [PyPI](https://pypi.org/project/mcp-server-time/) |

### Project Structure

```
quarkus-agentic-mcp/
├── src/main/java/
│   ├── Bot.java              # AI assistant configuration
│   └── BotWebsocket.java     # WebSocket endpoint
├── src/main/resources/
│   ├── application.properties # Configuration
│   └── META-INF/resources/
│       └── index.html        # Web UI
├── playground/               # Filesystem MCP workspace
├── pom.xml                   # Maven dependencies
├── .env                      # API keys (create this)
└── README.md                 # This file
```

### Configuration Reference

Key configuration properties in `application.properties`:

- **LLM Model**: `quarkus.langchain4j.openai.chat-model.model-name=gpt-4o-mini`
- **Temperature**: `quarkus.langchain4j.openai.chat-model.temperature=0.8`
- **Timeout**: `quarkus.langchain4j.openai.timeout=3m`
- **MCP Servers**: `quarkus.langchain4j.mcp.<server-name>.*`

### Contributing

Contributions are welcome! Please:
1. Fork the repository
2. Create a feature branch
3. Make your changes
4. Submit a pull request

### License

[Add your license information here]

---

**Built with ❤️ using Quarkus, LangChain4j, and Model Context Protocol**
