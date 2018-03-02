import { Component } from '@angular/core';
import { OnInit } from '@angular/core/src/metadata/lifecycle_hooks';
import { EquipamentoService } from './equipamento.service';
import { Clone } from '../clone';
import { Equipamento } from '../equipamento';
import { CloneService } from './clone.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title = 'app';
  clones: Clone[];
  images = ["assets/done1.jpg","assets/done2.jpg","assets/done3.jpg" ];
  equipamentos: Equipamento[];
  cloneSelecionado: Clone = new Clone();
  element: HTMLImageElement;

  constructor(private cloneService : CloneService, private equipamentoService: EquipamentoService){

  }

  ngOnInit(): void {
    this.carregarClones();
    this.carregarEquipamentos();
  }

  carregarClones(){
    this.cloneService.getAllClones().subscribe(clones => {
      this.clones = clones;
      let clone = new Clone();
      clone.id = 1;
      clone.nome = "XXX9999";
      clone.idade = 12;
      clone.dataCriacao = new Date();
      this.clones.push(clone);
      let clone2 = new Clone();
      clone2.id = 1;
      clone2.nome = "XXX9999";
      clone2.idade = 12;
      clone2.dataCriacao = new Date();
      this.clones.push(clone2);
    },err => console.error(err),
    () => console.log('Clones carregados'));
  }

  carregarEquipamentos(){
    this.equipamentoService.getAllEquipamentos().subscribe(equipamentos => {
      this.equipamentos = equipamentos;
    }, err => console.error(err.message),
    () => console.log('Equipamentos carregados'));
  }

  carregarImagem(clone : Clone){
    return this.images[Math.floor(Math.random() * this.images.length)];

    
  }
  

}
