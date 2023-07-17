import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ProductDetailComponent } from './screen/product-detail/product-detail.component';
import { BuyerInfosComponent } from './buyerInfos/buyerInfos.component';
import { BuyerInfoDetailComponent } from './buyerInfo-detail/buyerInfo-detail.component';

const routes: Routes = [
  { path: 'product/:id', component: ProductDetailComponent },
  { path: 'account', component: BuyerInfosComponent},
  { path: 'account/:id', component: BuyerInfoDetailComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
