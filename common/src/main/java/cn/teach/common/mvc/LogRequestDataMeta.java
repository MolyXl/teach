package cn.teach.common.mvc;

import java.util.List;

public class LogRequestDataMeta implements RequestDataMeta {
    public class MessageParameterMeta{
        private String name;
        private String type;
        private String url;

        /**
         * @return the name
         */
        public String getName() {
            return name;
        }

        /**
         * @return the url
         */
        public String getUrl() {
            return url;
        }

        /**
         * @param url the url to set
         */
        public void setUrl(String url) {
            this.url = url;
        }

        /**
         * @return the type
         */
        public String getType() {
            return type;
        }

        /**
         * @param type the type to set
         */
        public void setType(String type) {
            this.type = type;
        }

        /**
         * @param name the name to set
         */
        public void setName(String name) {
            this.name = name;
        }
    }

    private String name;
    private String message;
    private List<MessageParameterMeta> parameters;
    private IRequestHandler handler;

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the handler
     */
    public IRequestHandler getHandler() {
        return handler;
    }

    /**
     * @param handler the handler to set
     */
    public void setHandler(IRequestHandler handler) {
        this.handler = handler;
    }

    /**
     * @return the parameters
     */
    public List<MessageParameterMeta> getParameters() {
        return parameters;
    }

    /**
     * @param parameters the parameters to set
     */
    public void setParameters(List<MessageParameterMeta> parameters) {
        this.parameters = parameters;
    }

    /**
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * @param message the message to set
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

}