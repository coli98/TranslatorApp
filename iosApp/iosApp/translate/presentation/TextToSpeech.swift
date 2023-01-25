//
//  TextToSpeech.swift
//  iosApp
//
//  Created by Marcin Balchanowski on 23/01/2023.
//  Copyright © 2023 orgName. All rights reserved.
//

import Foundation
import AVFoundation

struct TextToSpeech {
    
    private let synthesizer = AVSpeechSynthesizer()
    
    func speak(text: String, language: String){
        let utternance = AVSpeechUtterance(string: text)
        utternance.voice = AVSpeechSynthesisVoice(language: language)
        utternance.volume = 1
        synthesizer.speak(utternance)
    }
}
