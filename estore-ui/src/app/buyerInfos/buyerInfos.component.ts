import { Component } from '@angular/core';
import { BuyerInfoService } from '../buyerInfo.service';
import { BuyerInfo } from '../type';

@Component({
  selector: 'app-buyerInfos',
  templateUrl: './buyerInfos.component.html',
  styleUrls: ['./buyerInfos.component.scss'],
})
export class BuyerInfosComponent {
  buyerInfos: BuyerInfo[] = [];

  constructor(private buyerInfoService: BuyerInfoService) {}

  ngOnInit() {
    this.getBuyerInfos();
  }

  getBuyerInfos() {
    this.buyerInfoService.getBuyerInfos().subscribe(this.setBuyerInfos);
  }

  setBuyerInfos(buyerInfos: BuyerInfo[]) {
    this.buyerInfos = buyerInfos;
  }

  addBuyerInfo(buyerInfo: BuyerInfo) {
    const id: number = 0; // Server will handle the actual buyerInfo ID, replacing this temporary value.
    this.buyerInfoService
      .addBuyerInfo(buyerInfo)
      .subscribe((buyerInfo: BuyerInfo) => {
        this.buyerInfos.push(buyerInfo);
        this.getBuyerInfos(); // Refreshes buyerInfo list
        console.log('BuyerInfo created successfully');
      });
  }

  addNewBuyerInfo(
    userid: number,
    firstName: string,
    lastName: string,
    phoneNumber: string
  ) {
    const newBuyerInfo: BuyerInfo = {
      id: 0, // temporary value
      userid,
      firstName,
      lastName,
      phoneNumber,
      pastOrdersIds: [],
      creditCards: [],
      shippingAddresses: [],
      cart: [],
      wishlist: [],
    };

    this.addBuyerInfo(newBuyerInfo);
  }

  updateBuyerInfo(buyerInfo: BuyerInfo) {
    this.buyerInfoService.updateBuyerInfo(buyerInfo).subscribe(() => {
      this.getBuyerInfos();
      console.log('BuyerInfo updated successfully');
    });
  }

  deleteBuyerInfo(id: number) {
    this.buyerInfoService.deleteBuyerInfo(id).subscribe(() => {
      this.getBuyerInfos();
      console.log('BuyerInfo deleted successfully');
    });
  }
}
