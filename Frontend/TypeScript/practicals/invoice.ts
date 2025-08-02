interface HasInvoice {
  format(): string;
}

class Invoice implements HasInvoice {
  constructor(
    private client: string,
    private details: string,
    private amount: number
  ) {}

  format(): string {
    return `${this.client} owes ₹${this.amount} for ${this.details}`;
  }
}

function generateInvoice() {
  const client = (document.getElementById("client") as HTMLInputElement).value;
  const details = (document.getElementById("details") as HTMLInputElement).value;
  const amount = parseFloat((document.getElementById("amount") as HTMLInputElement).value);

  const invoice = new Invoice(client, details, amount);
  document.getElementById("invoiceOutput")!.innerText = invoice.format();
}
