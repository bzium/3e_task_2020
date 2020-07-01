package p.lagodzinski.tree.e.services;

public class DivideByZeroException extends RuntimeException {
    private static final long serialVersionUID = -5148285147660173445L;

    public DivideByZeroException() {
        super("You can't divide by 0");
    }
}
