/**
 * Component Questions is defined as
 * `<e-questions>`
 *
 * Imperatively create component
 * @example
 * let component = new Questions();
 *
 * Declaratively create component
 * @example
 * <e-questions></e-questions>
 *
 * @extends {LitComponent}
 */
import { definition } from '@eui/component';
import { LitComponent, html } from '@eui/lit-component';
import style from './questions.css';

/**
 * @property {number} stageId
 */
@definition('e-questions', {
  style,
  home: 'questions',
  props: {
    questions: { attribute: false, type: Object },
    stage: {attribute: true, type: 'number'},
    question: {attribute: true, type: 'string'}
  },
})
export default class Questions extends LitComponent {
  /**
   * Render the <e-questions> component. This function is called each time a
   * prop changes.
   */
  
  // didConnect(){
  //   fetch('http://localhost:8081/question')
  //   .then(function(response) {
  //     return response.json()
  //   }).then(function(json) {
  //     this.questions = json
  //     console.log('Questions ', json)
  //   }.bind(this)).catch(function(ex) {
  //     console.log('parsing failed', ex)
  //   })
  // }
  

   render() {
    return html`
    <h2>${this.question}</h2>
    `;
  }
}

/**
 * Register the component as e-questions.
 * Registration can be done at a later time and with a different name
 */
Questions.register();
