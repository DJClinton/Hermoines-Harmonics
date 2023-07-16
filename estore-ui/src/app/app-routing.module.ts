import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ProductDetailComponent } from './screen/product-detail/product-detail.component';
import { BuyerInfosComponent } from './buyer-infos/buyer-infos.component';

const routes: Routes = [
  { path: 'product/:id', component: ProductDetailComponent },
  { path: 'account', component: BuyerInfosComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
