import { Component } from '@angular/core';
import { BuyerInfoService } from '../buyerInfo.service';
import { BuyerInfo } from '../buyerInfo';
import { CreditCard } from '../CreditCard';

@Component({
  selector: 'app-buyerInfos',
  templateUrl: './buyerInfos.component.html',
  styleUrls: ['./buyerInfos.component.scss']
})
export class BuyerInfosComponent {
  buyerInfos: BuyerInfo[] = [];

  constructor(private buyerInfoService: BuyerInfoService) {}

  ngOnInit() {
    this.buyerInfoService.getBuyerInfos();
  }

  getBuyerInfos() {
    this.buyerInfoService.getBuyerInfos().subscribe(buyerInfos => {
      this.buyerInfos = buyerInfos;
    });
  }

  addBuyerInfo(userid: number, firstName: string, lastName: string, phoneNumber: string, 
    pastOrderIds: Array<number>, creditCards: Array<CreditCard>, shippingAddresses: Array<String>,
    cart: Array<number>, wishlist: Array<number>) {

    const id: number = 0; // Server will handle the actual buyerInfo ID, replacing this temporary value.
    const newBuyerInfo: BuyerInfo = {id, userid, firstName, lastName, phoneNumber, pastOrderIds, creditCards, shippingAddresses, cart, wishlist};
    this.buyerInfoService.addBuyerInfo(newBuyerInfo).subscribe((buyerInfo: BuyerInfo) => {
      this.buyerInfos.push(buyerInfo);
      this.getBuyerInfos(); // Refreshes buyerInfo list
      console.log("BuyerInfo created successfully")
    });
  }

  updateBuyerInfo(buyerInfo: BuyerInfo) {
    this.buyerInfoService.updateBuyerInfo(buyerInfo).subscribe(() => {
      this.getBuyerInfos();
      console.log("BuyerInfo updated successfully")
    });
  }

  deleteBuyerInfo(id: number) {
    this.buyerInfoService.deleteBuyerInfo(id).subscribe(() => {
      this.getBuyerInfos();
      console.log("BuyerInfo deleted successfully")
    });
  }
}
