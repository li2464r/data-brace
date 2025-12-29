package com.racacia.regular.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author <a href="mailto:jieqiang.li-ext@ikang.com">jieqiang.li</a>
 * @date 2025-10-28 14:24
 */
@RestController
@RequestMapping
public class IndexController {

    @RequestMapping(value = {"/", "index"})
    public String index() {
        return """
                <!DOCTYPE html>
                <html lang="en">
                <head>
                    <meta charset="UTF-8">
                    <meta name="viewport" content="width=device-width, initial-scale=1.0">
                    <title>Service Status</title>
                    <style>
                        * {
                            margin: 0;
                            padding: 0;
                            box-sizing: border-box;
                        }
                
                        body {
                            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
                            background: linear-gradient(135deg, #6e8efb, #a777e3);
                            height: 100vh;
                            display: flex;
                            justify-content: center;
                            align-items: center;
                            color: #fff;
                        }
                
                        .container {
                            text-align: center;
                            padding: 2rem;
                            background: rgba(255, 255, 255, 0.1);
                            backdrop-filter: blur(10px);
                            border-radius: 20px;
                            box-shadow: 0 15px 35px rgba(0, 0, 0, 0.2);
                            max-width: 90%;
                            animation: fadeIn 1.5s ease-out;
                        }
                
                        .message {
                            font-size: 2.5rem;
                            font-weight: 300;
                            margin-bottom: 1rem;
                            letter-spacing: 1px;
                            text-shadow: 0 2px 10px rgba(0, 0, 0, 0.2);
                        }
                
                        .status-indicator {
                            display: inline-block;
                            width: 12px;
                            height: 12px;
                            background-color: #4CAF50;
                            border-radius: 50%;
                            margin-right: 10px;
                            animation: pulse 2s infinite;
                            vertical-align: middle;
                        }
                
                        .subtitle {
                            font-size: 1rem;
                            opacity: 0.8;
                            margin-top: 1rem;
                            font-weight: 300;
                        }
                
                        @keyframes fadeIn {
                            from {
                                opacity: 0;
                                transform: translateY(20px);
                            }
                            to {
                                opacity: 1;
                                transform: translateY(0);
                            }
                        }
                
                        @keyframes pulse {
                            0% {
                                transform: scale(0.95);
                                box-shadow: 0 0 0 0 rgba(76, 175, 80, 0.7);
                            }
                            70% {
                                transform: scale(1);
                                box-shadow: 0 0 0 10px rgba(76, 175, 80, 0);
                            }
                            100% {
                                transform: scale(0.95);
                                box-shadow: 0 0 0 0 rgba(76, 175, 80, 0);
                            }
                        }
                
                        @media (max-width: 768px) {
                            .message {
                                font-size: 1.8rem;
                            }
                        }
                
                        @media (max-width: 480px) {
                            .message {
                                font-size: 1.5rem;
                            }
                
                            .container {
                                padding: 1.5rem;
                            }
                        }
                    </style>
                </head>
                <body>
                <div class="container">
                    <h1 class="message">
                        <span class="status-indicator"></span>
                        data brace service is running...
                    </h1>
                    <p class="subtitle">All systems operational</p>
                </div>
                </body>
                </html>""";
    }

}
