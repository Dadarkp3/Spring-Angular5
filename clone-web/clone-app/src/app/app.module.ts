import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';


import { AppComponent } from './app.component';

import { EquipamentoService } from './equipamento.service';
import { CloneService } from './clone.service';
import { HttpClientModule } from '@angular/common/http';
import { DatePipe } from '@angular/common';


@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
  ],
  providers: [CloneService, EquipamentoService, HttpClientModule, DatePipe],
  bootstrap: [AppComponent]
})
export class AppModule { }
