export interface Product {
  id: number;
  name: string;
  tags: string[];
  description: string;
  price: number;
  quantity: number;
}

export interface BuyerInfo {
  id: number;
  userId: number;
  name: string;
  phoneNumber: string;
  pastOrdersIds: Array<number>;
  creditCards: Array<{ holderName: string, cardNumber: string }>;
  shippingAddresses: Array<String>;
  cart: Array<number>;
  wishlist: Array<number>;
}
