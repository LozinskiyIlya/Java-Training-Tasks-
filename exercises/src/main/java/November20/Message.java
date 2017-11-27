package November20;

class Message {
    String text;
    Client to;

    public Message(String text) {
        this.text = text;
    }

    public Message(String text, Client to) {
        this.text = text;
        this.to = to;
    }

    @Override
    public String toString() {
        return text;
    }
}
