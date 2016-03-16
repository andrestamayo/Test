/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function (){
    $('a').mouseenter(function (){
        $(this).animate({
           height: '+=10px'
           
       })
    });
    $('a').mouseleave(function() {
       $(this).animate({
           height: '-=10px'
       }); 
   });
})
