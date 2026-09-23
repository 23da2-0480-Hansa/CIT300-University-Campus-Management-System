public class ServiceRequest {
    private final String studentId;
    private final String request;

    public ServiceRequest(String studentId, String request) {
        this.studentId = studentId;
        this.request = request;
    }

    public String getStudentId() { return studentId; }
    public String getRequest() { return request; }

    @Override
    public String toString() {
        return "Student ID: " + studentId + " | Request: " + request;
    }
}
