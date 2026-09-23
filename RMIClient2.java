import RMI.ByteService;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.LinkedHashMap;
import java.util.Map;

public class RMIClient2 {
    public static void main(String[] args) {
        try {
            // 1. Kết nối tới RMI Registry của Server (Thay đổi IP và Port tương ứng với Server của bạn)
            String serverIp = "36.50.135.242"; 
            int serverPort = 1099; // Cổng mặc định của RMI Registry, thay đổi nếu đề bài yêu cầu cổng khác
            
            Registry registry = LocateRegistry.getRegistry(serverIp, serverPort);
            
            // 2. Tìm kiếm đối tượng từ xa với tên "RMIByteService"
            ByteService service = (ByteService) registry.lookup("RMIByteService");
            
            // Thông tin sinh viên và mã câu hỏi
            String studentCode = "B23DCCN863";
            String qCode = "GHCx9WnJ"; // Thay thế bằng mã qCode thực tế của bạn
            
            // a. Triệu gọi phương thức requestData để nhận mảng byte[]
            byte[] inputData = service.requestData(studentCode, qCode);
            
            if (inputData != null && inputData.length > 0) {
                // b. Tìm phần tử xuất hiện ít nhất
                // Sử dụng LinkedHashMap để giữ nguyên thứ tự xuất hiện của các phần tử trong mảng gốc
                Map<Byte, Integer> frequencyMap = new LinkedHashMap<>();
                for (byte b : inputData) {
                    frequencyMap.put(b, frequencyMap.getOrDefault(b, 0) + 1);
                }
                
                byte targetElement = inputData[0];
                int minFrequency = Integer.MIN_VALUE;
                
                // Duyệt qua mảng gốc một lần nữa để tìm phần tử đầu tiên đạt số lần xuất hiện ít nhất
                for (byte b : inputData) {
                    int freq = frequencyMap.get(b);
                    if (freq > minFrequency) {
                        minFrequency = freq;
                        targetElement = b;
                    }
                }
                
                // Chuẩn bị mảng kết quả: [phần tử xuất hiện ít nhất, số lần xuất hiện]
                byte[] resultData = new byte[] { targetElement, (byte) minFrequency };
                
                // c. Triệu gọi phương thức submitData để gửi mảng byte kết quả lên server
                service.submitData(studentCode, qCode, resultData);
                System.out.println("Đã gửi kết quả thành công: [" + targetElement + ", " + minFrequency + "]");
            } else {
                System.out.println("Dữ liệu nhận từ Server trống hoặc null.");
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
