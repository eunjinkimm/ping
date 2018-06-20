import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

class PortScanner {
	
	public static void main(final String... args) throws InterruptedException, ExecutionException {
		final ExecutorService es = Executors.newFixedThreadPool(20);
		final String ip = "127.0.0.1";
		final int timeout = 20;
		final List<Future<ScanResult>> futures = new ArrayList<>();
		//65535 , 1024
		for (int port = 1; port <=1024; port++) {
			futures.add(portIsOpen(es, ip, port, timeout));
		}
		es.awaitTermination(200L, TimeUnit.MILLISECONDS);
		int openPorts = 0;
		String openPortNumber = "";
		for (final Future<ScanResult> f : futures) {
			if (f.get().isOpen()) {
				openPorts++;
				openPortNumber += f.get().getPort() + ", ";
			}
		}
		System.out.println(openPortNumber.substring(0, openPortNumber.length()-2));
		System.out.println();
	}
	
	
	
}
