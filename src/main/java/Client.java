import org.supermarket.dao.daoInterface.*;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;

public class Client {
	public static void main (String[] args) {
		try{
			int port = 9000;
			CustomerDao customerDao = (CustomerDao) Client.connectTo(port, Option.CUSTOMER_DAO);
			EmployeeDao employeeDao = (EmployeeDao) Client.connectTo(port, Option.EMPLOYEE_DAO);
			SupplierDao supplierDao = (SupplierDao) Client.connectTo(port, Option.SUPPLIER_DAO);
			ProductDao productDao = (ProductDao) Client.connectTo(port, Option.PRODUCT_DAO);
			OrderDao orderDao = (OrderDao) Client.connectTo(port, Option.ORDER_DAO);
			ReceiptDao receiptDao = (ReceiptDao) Client.connectTo(port, Option.RECEIPT_DAO);


//			Employee employee = employeeDao.getEmployeeById(1L); //ADMIN
//			Supplier supplier = new Supplier("AASVV", "HCM", "046151656", "manh@mail.com");
//			Product product = new Product("Nước rửa chén", 15000, Category.HOUSEWARES, "nước rửa chén sạch",
//					LocalDate.of(2020, 5, 10), null, 10);
//			Product product1 = new Product("Gạo ST25", 45000, Category.FOOD, "Gạo VN",
//					LocalDate.of(2021, 5, 10), LocalDate.of(2030, 10, 1), 50);
//			Product product2 = new Product("Bia", 11000, Category.DRINK, "Bia Ngon",
//					LocalDate.of(2022, 7, 30), LocalDate.now().plusYears(3), 100);
//			List<Product> productList = new ArrayList<>();
//			productList.add(product);
//			productList.add(product1);
//			productList.add(product2);
//
//			receiptDao.addReceipt(new Receipt(supplier,employee,productList,LocalDate.now()));
//			receiptDao.getAllReceipt().forEach(System.out::println);
		
		
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static Remote connectTo (int port, Option option) throws RemoteException, MalformedURLException, NotBoundException {
		String res = "rmi://localhost:" + port + "/" + option.getValue();
		return Naming.lookup(res);
	}
}
