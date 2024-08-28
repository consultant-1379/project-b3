/**
 * App1 is defined as
 * `<e-app-1>`
 *
 * Imperatively create application
 * @example
 * let app = new App1();
 *
 * Declaratively create application
 * @example
 * <e-app-1></e-app-1>
 *
 * @extends {App}
 */
import { definition } from '@eui/component';
import { App, html } from '@eui/app';
import '@eui/table';
import style from './app1.css';
import "../../../components/questions/src/Questions";
import "../../../components/sub-question/src/SubQuestion";
import "../../../components/landing_page/src/Landing_page";

@definition('e-app-1', {
  style,
  props: {
    stage: {attribute: false, type: 'string'},
    
    questionId: {attribute: false, type: 'number', default: 1},
    leadingQuestion: {attribute: false, type: 'string', default: "Hello"},
    leadingQuestionID: {attribute: false, type: 'number'},
    leadQuesResp: {attribute: false, type: 'string', default: ""},
    
    subQuestions: {attribute: false, type: []},
    subQuestionId: {attribute: false, type: 'number', default:1},
    subQuestion: {attribute: false, type: 'string'},
    subQuesDesc: {attribute: false, type: Array, default: []},
    displaySubQues: {attribute: false, type: Boolean, default: false},
    ques_len: {attribute: false, type: 'number', default: 1},
    sub_questions_response: {attribute: false, type: Array, default: []},

    response: {attribute: false, type: Array, default: []},
    isCompleted: {attribute: false, type: Boolean, default: false},
    enableQuestions : {attribute: false, type: Boolean, default: false}
    }})
export default class App1 extends App {
  /**
   * Uncomment this block to add initialization code
   * constructor() {
   *   super();
   *   // initialize
   * }
   */

  /**
  * Render the <e-app-1> app. This function is called each time a
  * prop changes.
  */
  didConnect(){
    this._loadQues();
    this._loadSubQues();
  }
  
  
  _loadQues(){
    fetch(`http://localhost:8081/questions/${this.questionId}`)
    .then(function(response) {
      return response.json()
    }).then(function(json) {
      this.stage = Object.keys(json);
      this.leadingQuestion = json[this.stage].description;
      this.leadingQuestionID = json[this.stage].id;
      // this.subQuestions = json[this.stage];
      // console.log('Question ', json)
      // console.log('Leading Question ', this.leadingQuestion)
    }.bind(this)).catch(function(ex) {
      console.log('parsing failed', ex)
    })
  }
  

  _loadSubQues(){
    fetch(`http://localhost:8081/questions/${this.questionId}/subQuestions`)
    .then(function(response) {
      return response.json()
    }).then(function(json) {
      this.subQuestions = json[this.stage];
      
      this.subQuestions.forEach(function(obj) { 
        this.subQuesDesc.push({"stage_id": this.leadingQuestionID,"id":obj.id,"subQuestion":obj.description});
      }, this);

      // console.log(this.subQuestions);
      // console.log(this.subQuesDesc);
    }.bind(this)).catch(function(ex) {
      console.log('parsing failed', ex)
    })
  }


  _saveStageResponse(){
    
    if(this.leadQuesResp === ""){
      alert("Please select your response");
      return false;
    }

    if(this.leadQuesResp === "NO" && this.sub_questions_response.length != this.subQuesDesc.length){
      alert("Please answer all the questions");
      return false;
    }
    
    this.questionId += 1;

    this.response.push({
        "stage_id": this.leadingQuestionID,
        "lead_question": this.leadQuesResp,
        "sub_question": this.sub_questions_response
    });

    //console.log(this.response);

    this.leadQuesResp = "";
    this.sub_questions_response = [];
    this.subQuesDesc = [];
    this.displaySubQues = false;


    if(this.questionId === 10){
      this.isCompleted = true;
    }
    else{
      this._loadQues()
      this._loadSubQues()
    }
    
  }
  


  _getColor(i, model){
    if(this.response.length == 9){
      if(this.response[i].lead_response==="YES" && model === "agile"){
        return "background-color:blue;";
      }
      else if(this.response[i].lead_response==="NO" && model === "water"){
        return "background-color:blue;";
      }
    }
  }

  _storeSubQuestionResponse(i, event){
    this.sub_questions_response.push(event.target.value);
  }


  _setLeadingQuestionResponse(event){
    this.leadQuesResp = event.target.value;
    if(this.leadQuesResp === "NO"){
      this.displaySubQues = true;
    }
  }

  _displaySubQuestions(){
    const itemTemplates = [];
    for(var i=0; i<this.subQuesDesc.length;i++){
      itemTemplates.push(html`<tr>
        <td><e-sub-question questions='${this.subQuesDesc[i].subQuestion}'></e-sub-question></td>
        <td align="center">
          <eui-base-v0-dropdown label="Option" data-type="single">
          <eui-base-v0-menu-item value="YES" label="YES" @eui-menuItem:click="${(event) => this._storeSubQuestionResponse(i, event)}"></eui-base-v0-menu-item>
          <eui-base-v0-menu-item value="NO" label="NO" @eui-menuItem:click="${(event) => this._storeSubQuestionResponse(i, event)}"></eui-base-v0-menu-item>
          </eui-base-v0-dropdown>
        </td>
      </tr> 
     `);
    }
    return itemTemplates;
  }


  _markValuesFromResponse(columnId,stageId){
        if(this.isCompleted){
         const iconBold = html`<eui-v0-icon name="alarm-level4"></eui-v0-icon>`;
         const iconNormal = html`<eui-v0-icon name="node"></eui-v0-icon>`;
          //console.log(stageId);
          //console.log(columnId);
          console.log('response in _markValuesFromResponse ',this.response);
          if(this.response[stageId].lead_question==="YES" && columnId===5){
            return iconBold;
         }
         if(this.response[stageId].lead_question==="NO" ){
             const subQ = this.response[stageId].sub_question;
             //console.log(subQ);
               if( (subQ[0]==="YES" && subQ[2]==="YES") && (subQ[1]==="YES" && subQ[3]==="YES") && columnId===3 ){
                       return iconBold;
               }

               if( (subQ[0]==="YES" && subQ[2]==="NO") && (subQ[1]==="NO" && subQ[3]==="YES") && columnId===3 ){
                      return iconBold;
              }

              if( (subQ[0]==="NO" && subQ[2]==="YES") && (subQ[1]==="YES" && subQ[3]==="NO") && columnId===3 ){
                    return iconBold;
            }
            if( (subQ[0]==="YES" && subQ[2]==="NO") && (subQ[1]==="YES" && subQ[3]==="NO") && columnId===3 ){
                    return iconBold;
            }
            if( (subQ[0]==="NO" && subQ[2]==="NO") && (subQ[1]==="NO" && subQ[3]==="NO") && columnId===3 ){
                       return iconBold;
               }
               if( (subQ[0]==="YES" || subQ[2]==="YES")  && (subQ[1]==="NO" && subQ[3]==="NO") && columnId===2 ){
                   if(subQ[0]==="YES" && subQ[2]==="YES"){
                        return iconBold;
                   }
                   return iconBold;
              }

               if( (subQ[1]==="YES" || subQ[3]==="YES")  && (subQ[0]==="NO" && subQ[2]==="NO") && columnId===4 ){
                  if(subQ[1]==="YES" && subQ[3]==="YES"){
                       return iconBold;
                  }
                  return iconBold;
             }
         }
          //return iconNormal;
     }
  }

  _displaySecondPage(){
    this.enableQuestions = true;
  }

  render() {
    const { EUI } = window;

    const ques = html`
    <table align="center">
    <tr>
      <td align="center"><h1>${this.stage}</h1><td>
    </tr>
    <tr>
      <td><e-questions question='${this.leadingQuestion}'></e-questions></td>
    </tr> 
    <tr>
      <td align="center">
        <eui-base-v0-dropdown label="Option" data-type="single">
        <eui-base-v0-menu-item value="YES" label="YES" @eui-menuItem:click="${(event) => this._setLeadingQuestionResponse(event)}"></eui-base-v0-menu-item>
        <eui-base-v0-menu-item value="NO" label="NO" @eui-menuItem:click="${(event) => this._setLeadingQuestionResponse(event)}"></eui-base-v0-menu-item>
        </eui-base-v0-dropdown>
      </td>
    </tr>
   <table>
    <div align="center" style="margin-top:20px;">
      <eui-base-v0-button @click="${() => this._saveStageResponse()}">Next Question</eui-base-v0-button>
    </div>
    `;

    const sub_ques = html`
    <table align="center" width=60%>
    <tr>
      <td align="center"><h1>${this.stage}</h1><td>
    </tr>
    ${this._displaySubQuestions()}
    <tr>
      <td align="center">
        <eui-base-v0-button @click="${() => this._saveStageResponse()}">Next Question</eui-base-v0-button>
      </td>
    </tr>
   <table>
    `;





     const columns = [
       { title: 'Stage', attribute: 'col1' ,resizable:'yes'},
       { title: 'NO PROCESS', attribute: 'col2' ,resizable:'yes'},
       { title: 'WATERFALL', attribute: 'col3' ,resizable:'yes'},
       { title: '', attribute: 'col4',width:'80px'},
       { title: 'AGILE', attribute: 'col5' ,resizable:'yes'},
       { title: 'CLOUD NATIVE', attribute: 'col6' ,resizable:'yes'},
       { title: 'NEXT', attribute: 'col7',resizable:'yes' }
     ];
     const tableData = [
       { col1: 'CULTURE', col2: 'Individualist', col3: 'Predictive',col4:'',col5:'Iterative',col6:'Collaborative',col7:'Experimental'},
      { col1: '', col2: this._markValuesFromResponse(1,0), col3: this._markValuesFromResponse(2,0),col4:this._markValuesFromResponse(3,0),col5:this._markValuesFromResponse(4,0),col6:this._markValuesFromResponse(5,0),col7:this._markValuesFromResponse(6,0)},
      { col1: 'PROD/SERVICE DESIGN', col2: 'Arbitrary', col3: 'Long-term plan',col4:'',col5:'Feature driven',col6:'Data driven',col7:'All driven'},
      { col1: '', col2: this._markValuesFromResponse(1,1), col3: this._markValuesFromResponse(2,1),col4:this._markValuesFromResponse(3,1),col5:this._markValuesFromResponse(4,1),col6:this._markValuesFromResponse(5,1),col7:this._markValuesFromResponse(6,1)},
      { col1: 'TEAM', col2: 'No organization,single contributor', col3: 'Hierarchy',col4:'',col5:'Cross-functional teams',col6:'Devops/sre',col7:'Internal Supply Chains'},
      { col1: '', col2: this._markValuesFromResponse(1,2), col3: this._markValuesFromResponse(2,2),col4:this._markValuesFromResponse(3,2),col5:this._markValuesFromResponse(4,2),col6:this._markValuesFromResponse(5,2),col7:this._markValuesFromResponse(6,2)},
      {col1: 'PROCESS', col2: 'Random', col3: 'Waterfall',col4:'',col5:'Agile(Scrum/Kanban)',col6:'Design Thinking + Agile + Lean',col7:'Distributed,self-organized'},
      { col1: '', col2: this._markValuesFromResponse(1,3), col3: this._markValuesFromResponse(2,3),col4:this._markValuesFromResponse(3,3),col5:this._markValuesFromResponse(4,3),col6:this._markValuesFromResponse(5,3),col7:this._markValuesFromResponse(6,3)},
      {col1: 'ARCHITECTURE', col2: 'Emerging from trial and error', col3: 'Tightly coupled monolith',col4:'',col5:'Client Server',col6:'Microservices',col7:'Functions'},
       { col1: '', col2: this._markValuesFromResponse(1,4), col3: this._markValuesFromResponse(2,4),col4:this._markValuesFromResponse(3,4),col5:this._markValuesFromResponse(4,4),col6:this._markValuesFromResponse(5,4),col7:this._markValuesFromResponse(6,4)},
      {col1: 'MAINTENANCE', col2: 'Respond to user complaints', col3: 'Ad-hoc monitoring',col4:'',col5:'Alerting',col6:'Full observability & self-healing',col7:'Preventive ML,AI'},
       { col1: '', col2: this._markValuesFromResponse(1,5), col3: this._markValuesFromResponse(2,5),col4:this._markValuesFromResponse(3,5),col5:this._markValuesFromResponse(4,5),col6:this._markValuesFromResponse(5,5),col7:this._markValuesFromResponse(6,5)},
      {col1: 'DELIVERY', col2: 'Irregular', col3: 'Periodic releases',col4:'',col5:'Continuous Integration',col6:'Continuous Delivery',col7:'Continuous Deployment'},
       { col1: '', col2: this._markValuesFromResponse(1,6), col3: this._markValuesFromResponse(2,6),col4:this._markValuesFromResponse(3,6),col5:this._markValuesFromResponse(4,6),col6:this._markValuesFromResponse(5,6),col7:this._markValuesFromResponse(6,6)},
      {col1: 'PROVISIONING', col2: 'Manual', col3: 'Scripted',col4:'',col5:'Config. management(Public/Chef/Ansible)',col6:'Orchestration(Kubernetes)',col7:'Serverless'},
       { col1: '', col2: this._markValuesFromResponse(1,7), col3: this._markValuesFromResponse(2,7),col4:this._markValuesFromResponse(3,7),col5:this._markValuesFromResponse(4,7),col6:this._markValuesFromResponse(5,7),col7:this._markValuesFromResponse(6,7)},
      {col1: 'INFRASTRUCTURE', col2: 'Single Server', col3: 'Multiple Servers',col4:'',col5:'VMs (pets)',col6:'Containers/hybrid cloud(cattle)',col7:'Edge computing'},
       { col1: '', col2: this._markValuesFromResponse(1,8), col3: this._markValuesFromResponse(2,8),col4:this._markValuesFromResponse(3,8),col5:this._markValuesFromResponse(4,8),col6:this._markValuesFromResponse(5,8),col7:this._markValuesFromResponse(6,8)},
     ];

    const matrix = html `
    <h1>Cloud Native Maturity Matrix</h1>
    <eui-table-v0 .columns=${columns} .data=${tableData} compact dashed  style="text-align: center"></eui-table-v0>`;

      const first_page = html`
        <div id="middle_div">
            <e-landing_page ></e-landing_page>
            <center><eui-base-v0-button @click="${() => this._displaySecondPage()}">Generate Matrix</eui-base-v0-button></center>
        </div>
        `;

    const second_page = html `${
            this.isCompleted === false && this.displaySubQues === false ? ques :
            this.isCompleted === false && this.displaySubQues === true ? sub_ques :
            matrix
          }`;

    return html`
          ${ this.enableQuestions ? second_page : first_page}
          `;
  }
}

/**
 * Register the component as e-app-1.
 * Registration can be done at a later time and with a different name
 * Uncomment the below line to register the App if used outside the container
 *      ${this.isCompleted === false?ques:matrix}
        ${sub_ques}
 *  
 */
// App1.register();
