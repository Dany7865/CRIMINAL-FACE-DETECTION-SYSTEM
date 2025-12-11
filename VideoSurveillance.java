import org.opencv.core.Rect.*;
import org.opencv.videoio.VideoCapture;
import org.opencv.imgproc.Imgproc;
import org.opencv.objdetect.CascadeClassifier;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import org.w3c.dom.css.Rect;

public class VideoSurveillance extends JFrame {

    JLabel cameraLabel;

    public VideoSurveillance() {

        setTitle("Video Surveillance");
        setSize(1000, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(new Color(15, 35, 65));

        // LEFT CAMERA FEED
        cameraLabel = new JLabel();
        cameraLabel.setPreferredSize(new Dimension(600, 600));
        mainPanel.add(cameraLabel, BorderLayout.WEST);

        // RIGHT DETECTED CRIMINALS PANEL
        JPanel detectedPanel = new JPanel();
        detectedPanel.setBackground(new Color(30, 50, 90));
        detectedPanel.setPreferredSize(new Dimension(300, 600));

        JLabel title = new JLabel("Detected Criminals");
        title.setForeground(Color.WHITE);
        title.setFont(new Font("Arial", Font.BOLD, 18));

        detectedPanel.add(title);
        mainPanel.add(detectedPanel, BorderLayout.EAST);

        add(mainPanel);
        setVisible(true);

        startCamera();
    }

    private void startCamera() {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);

        VideoCapture camera = new VideoCapture(0);
        CascadeClassifier faceDetector = new CascadeClassifier("haarcascade_frontalface_alt.xml");

        new Thread(() -> {
            Mat frame = new Mat();
            while (camera.read(frame)) {
                MatOfRect faces = new MatOfRect();
                faceDetector.detectMultiScale(frame, faces);

                for (Rect rect : faces.toArray()) {
                    Imgproc.rectangle(frame, new Point(rect.x, rect.y),
                            new Point(rect.x + rect.width, rect.y + rect.height),
                            new Scalar(0, 255, 0), 2);
                }

                updateCameraView(frame);
            }
        }).start();
    }

    private void updateCameraView(Mat frame) {
        BufferedImage img = matToBufferedImage(frame);
        if (img != null) {
            ImageIcon icon = new ImageIcon(img);
            cameraLabel.setIcon(icon);
        }
    }

    private BufferedImage matToBufferedImage(Mat matrix) {
        int width = matrix.width(), height = matrix.height(), channels = matrix.channels();
        byte[] source = new byte[width * height * channels];
        matrix.get(0, 0, source);

        BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_3BYTE_BGR);
        img.getRaster().setDataElements(0, 0, width, height, source);
        return img;
    }

    private static class CascadeClassifier {

        public CascadeClassifier(String haarcascade_frontalface_altxml) {
        }

        private void detectMultiScale(Mat frame, MatOfRect faces) {
            throw new UnsupportedOperationException("Not supported yet.");
        }
    }

    private static class MatOfRect {

        public MatOfRect() {
        }

        private Iterable<Rect> toArray() {
            throw new UnsupportedOperationException("Not supported yet.");
        }
    }

    private static class Mat {

        public Mat() {
        }

        private int channels() {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        private int height() {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        private int width() {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        private void get(int i, int i0, byte[] source) {
            throw new UnsupportedOperationException("Not supported yet.");
        }
    }

    private static class Imgproc {

        private static void rectangle(Mat frame, Point point, Point point0, Scalar scalar, int i) {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        public Imgproc() {
        }
    }

    private static class Scalar {

        public Scalar(int i, int i0, int i1) {
        }
    }

    private static class Core {

        private static String NATIVE_LIBRARY_NAME;

        public Core() {
        }
    }
}
