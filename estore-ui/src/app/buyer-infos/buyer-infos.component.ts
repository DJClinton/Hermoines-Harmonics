import { Component } from '@angular/core';
import { BuyerInfoService } from '../buyer-info.service';
import { BuyerInfo } from '../buyer-info';
import { CreditCard } from '../CreditCard';

@Component({
  selector: 'app-buyer-infos',
  templateUrl: './buyer-infos.component.html',
  styleUrls: ['./buyer-infos.component.scss']
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

  addBuyerInfo(userid: number, firstName: string, lastName: string, phoneNumber: string, paymentMethod: CreditCard) {

    const id: number = 0; // Server will handle the actual buyerInfo ID, replacing this temporary value.
    const newBuyerInfo: BuyerInfo = {id, userid, firstName, lastName, phoneNumber, paymentMethod};
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
