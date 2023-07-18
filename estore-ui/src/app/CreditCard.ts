export class CreditCard {
    holderName: string;
    cardNumber: number;

    constructor(name: string, num: number) {
      this.holderName = name;
      this.cardNumber = num;
    }
  }