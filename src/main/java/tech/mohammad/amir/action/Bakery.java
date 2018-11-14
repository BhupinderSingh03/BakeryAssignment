package tech.mohammad.amir.action;

import tech.mohammad.amir.io.Reader;
import tech.mohammad.amir.io.impl.UserInputReader;

import static tech.mohammad.amir.common.Constants.LINE;
import static tech.mohammad.amir.common.Constants.ORDER_TEXT;
import static tech.mohammad.amir.io.impl.ConsoleWriter.write;

public class Bakery {
    private Reader reader = UserInputReader.getInstance();
    private OrderProcessor orderProcessor;
    private boolean open;

    public void open() {
        this.open = true;
        orderProcessor = new OrderProcessor(this);

        while (open) {
            write(ORDER_TEXT);
            orderProcessor.process(reader.readValue());
            write(LINE);
        }
    }

    public void close() {
        this.open = false;
    }
}
