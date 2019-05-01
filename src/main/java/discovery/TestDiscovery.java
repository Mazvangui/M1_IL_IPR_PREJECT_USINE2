package discovery;

public class TestDiscovery {

	public static void main(String[] args) throws InterruptedException {
		Runnable listener = () -> {
			Discovery.listenAndReply();
		};
		new Thread(listener).start();

		Discovery.sendWhois("051005022");
		Discovery.sendIAM("tftp", "127.0.0.1:6969");
		Discovery.treat("iam" , "224.3.2.1:9090" , "051005022");

		Thread.sleep(10000);

	}
}
