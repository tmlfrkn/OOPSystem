public class ContainerIsShippedException extends Exception{
    public ContainerIsShippedException() {
        super("Container has been already shipped");
    }
}
