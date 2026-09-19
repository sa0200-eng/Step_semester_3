interface PrintableLabel {

    String printLabel();
}


class PackageBoxLabel implements PrintableLabel {

    private String trackingId;

    public PackageBoxLabel(String trackingId) {
        this.trackingId = trackingId;
    }

    @Override
    public String printLabel() {
        return "Package label: " + trackingId;
    }
}


class InvoiceLabel implements PrintableLabel {

    private String invoiceNumber;

    public InvoiceLabel(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    @Override
    public String printLabel() {
        return "Invoice label: " + invoiceNumber;
    }
}


public class WarehouseLabelPrinter {

    public static void printAll(PrintableLabel[] items) {

        for (PrintableLabel item : items) {
            System.out.println(item.printLabel());
        }
    }


    public static void main(String[] args) {

        PackageBoxLabel p =
                new PackageBoxLabel("TRK-88");

        InvoiceLabel i =
                new InvoiceLabel("INV-42");

        System.out.println(p.printLabel());
        System.out.println(i.printLabel());

        printAll(new PrintableLabel[]{p, i});
    }
}