package com.faheemsaleem.calculatercompose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview
@Composable
fun CalculaterLayoutPreview()
{
    Column(
        modifier = Modifier
        .fillMaxWidth(),
        verticalArrangement =  Arrangement.spacedBy(8.dp)

    ) {
        // AC, DEL, /
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            CalculatorButton(
                symbol = "AC",
                modifier = Modifier
                    .background(MaterialTheme.colorScheme.onPrimary)
                    .aspectRatio(1f)
                    .weight(1f),
                onClick = {
                }
            )
            CalculatorButton(
                symbol = "Del",
                modifier = Modifier
                    .background(MaterialTheme.colorScheme.secondaryContainer)
                    .aspectRatio(1f)
                    .weight(1f),
                onClick = {
                }
            )

            CalculatorButton(
                symbol = "^",
                modifier = Modifier
                    .background(MaterialTheme.colorScheme.secondaryContainer)
                    .aspectRatio(1f)
                    .weight(1f),
                onClick = {
                }
            )

            CalculatorButton(
                symbol = "/",
                modifier = Modifier
                    .background(MaterialTheme.colorScheme.tertiaryContainer)
                    .aspectRatio(1f)
                    .weight(1f),
                onClick = {
                }
            )
        }

        //
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            CalculatorButton(
                symbol = "7",
                modifier = Modifier
                    .background(MaterialTheme.colorScheme.onPrimary)
                    .aspectRatio(1f)
                    .weight(1f),
                onClick = {
                }
            )
            CalculatorButton(
                symbol = "8",
                modifier = Modifier
                    .background(MaterialTheme.colorScheme.onPrimary)
                    .aspectRatio(1f)
                    .weight(1f),
                onClick = {
                }
            )
            CalculatorButton(
                symbol = "9",
                modifier = Modifier
                    .background(MaterialTheme.colorScheme.onPrimary)
                    .aspectRatio(1f)
                    .weight(1f),
                onClick = {
                }
            )
            CalculatorButton(
                symbol = "x",
                modifier = Modifier
                    .background(MaterialTheme.colorScheme.tertiaryContainer)
                    .aspectRatio(1f)
                    .weight(1f),
                onClick = {
                }
            )
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            CalculatorButton(
                symbol = "4",
                modifier = Modifier
                    .background(MaterialTheme.colorScheme.onPrimary)
                    .aspectRatio(1f)
                    .weight(1f),
                onClick = {
                }
            )
            CalculatorButton(
                symbol = "5",
                modifier = Modifier
                    .background(MaterialTheme.colorScheme.onPrimary)
                    .aspectRatio(1f)
                    .weight(1f),
                onClick = {
                }
            )
            CalculatorButton(
                symbol = "6",
                modifier = Modifier
                    .background(MaterialTheme.colorScheme.onPrimary)
                    .aspectRatio(1f)
                    .weight(1f),
                onClick = {
                }
            )
            CalculatorButton(
                symbol = "-",
                modifier = Modifier
                    .background(MaterialTheme.colorScheme.tertiaryContainer)
                    .aspectRatio(1f)
                    .weight(1f),
                onClick = {
                }
            )
        }


        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            CalculatorButton(
                symbol = "1",
                modifier = Modifier
                    .background(MaterialTheme.colorScheme.onPrimary)
                    .aspectRatio(1f)
                    .weight(1f),
                onClick = {
                }
            )
            CalculatorButton(
                symbol = "2",
                modifier = Modifier
                    .background(MaterialTheme.colorScheme.onPrimary)
                    .aspectRatio(1f)
                    .weight(1f),
                onClick = {
                }
            )
            CalculatorButton(
                symbol = "3",
                modifier = Modifier
                    .background(MaterialTheme.colorScheme.onPrimary)
                    .aspectRatio(1f)
                    .weight(1f),
                onClick = {
                }
            )
            CalculatorButton(
                symbol = "+",
                modifier = Modifier
                    .background(MaterialTheme.colorScheme.tertiaryContainer)
                    .aspectRatio(1f)
                    .weight(1f),
                onClick = {
                }
            )
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            CalculatorButton(
                symbol = "0",
                modifier = Modifier
                    .background(MaterialTheme.colorScheme.onPrimary)
                    .aspectRatio(2f)
                    .weight(2f),
                onClick = {
                }
            )
            CalculatorButton(
                symbol = ".",
                modifier = Modifier
                    .background(MaterialTheme.colorScheme.secondaryContainer)
                    .aspectRatio(1f)
                    .weight(1f),
                onClick = {
                }
            )
            CalculatorButton(
                symbol = "=",
                modifier = Modifier
                    .background(MaterialTheme.colorScheme.tertiaryContainer)
                    .aspectRatio(1f)
                    .weight(1f),
                onClick = {
                }
            )

        }
    }
}


@Composable
fun Calculator(
    state: CalculatorState,
    modifier: Modifier = Modifier,
    buttonSpacing: Dp = 8.dp,
    onAction: (CalculatorAction) -> Unit
) {
    Box(modifier = modifier){
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter),
            verticalArrangement =  Arrangement.spacedBy(buttonSpacing)
        ) {
            Text(
                text = state.result ?:"",
                textAlign = TextAlign.End,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                fontWeight = FontWeight.ExtraLight,
                fontSize = 30.sp,
                color = MaterialTheme.colorScheme.primary
            )

            val displayText = state.number1 + (state.operation?.symbol ?: "") + state.number2
            val fontSize = when {
                displayText.length > 10 -> 40.sp
                else -> 70.sp
            }

            Text(
                text = displayText,
                textAlign = TextAlign.End,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 16.dp),
                fontWeight = FontWeight.Light,
                fontSize = fontSize,
                color = MaterialTheme.colorScheme.onSurface,
                maxLines = 2
            )

            // AC, DEL, /
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
            ) {
                CalculatorButton(
                    symbol = "AC",
                    modifier = Modifier
                        .background(MaterialTheme.colorScheme.secondaryContainer)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CalculatorAction.Clear)
                    }
                )
                CalculatorButton(
                    symbol = "Del",
                    modifier = Modifier
                        .background(MaterialTheme.colorScheme.secondaryContainer)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CalculatorAction.Delete)
                    }
                )

                CalculatorButton(
                    symbol = "^",
                    modifier = Modifier
                        .background(MaterialTheme.colorScheme.secondaryContainer)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CalculatorAction.Power)
                    }
                )

                CalculatorButton(
                    symbol = "/",
                    modifier = Modifier
                        .background(MaterialTheme.colorScheme.tertiaryContainer)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CalculatorAction.Operation(CalculatorOperation.Divide))
                    }
                )
            }

            //
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
            ) {
                CalculatorButton(
                    symbol = "7",
                    modifier = Modifier
                        .background(MaterialTheme.colorScheme.onPrimary)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CalculatorAction.Number(7))
                    }
                )
                CalculatorButton(
                    symbol = "8",
                    modifier = Modifier
                        .background(MaterialTheme.colorScheme.onPrimary)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CalculatorAction.Number(8))
                    }
                )
                CalculatorButton(
                    symbol = "9",
                    modifier = Modifier
                        .background(MaterialTheme.colorScheme.onPrimary)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CalculatorAction.Number(9))
                    }
                )
                CalculatorButton(
                    symbol = "x",
                    modifier = Modifier
                        .background(MaterialTheme.colorScheme.tertiaryContainer)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CalculatorAction.Operation(CalculatorOperation.Multiply))
                    }
                )
            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
            ) {
                CalculatorButton(
                    symbol = "4",
                    modifier = Modifier
                        .background(MaterialTheme.colorScheme.onPrimary)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CalculatorAction.Number(4))
                    }
                )
                CalculatorButton(
                    symbol = "5",
                    modifier = Modifier
                        .background(MaterialTheme.colorScheme.onPrimary)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CalculatorAction.Number(5))
                    }
                )
                CalculatorButton(
                    symbol = "6",
                    modifier = Modifier
                        .background(MaterialTheme.colorScheme.onPrimary)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CalculatorAction.Number(6))
                    }
                )
                CalculatorButton(
                    symbol = "-",
                    modifier = Modifier
                        .background(MaterialTheme.colorScheme.tertiaryContainer)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CalculatorAction.Operation(CalculatorOperation.Subtract))
                    }
                )
            }


            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
            ) {
                CalculatorButton(
                    symbol = "1",
                    modifier = Modifier
                        .background(MaterialTheme.colorScheme.onPrimary)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CalculatorAction.Number(1))
                    }
                )
                CalculatorButton(
                    symbol = "2",
                    modifier = Modifier
                        .background(MaterialTheme.colorScheme.onPrimary)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CalculatorAction.Number(2))
                    }
                )
                CalculatorButton(
                    symbol = "3",
                    modifier = Modifier
                        .background(MaterialTheme.colorScheme.onPrimary)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CalculatorAction.Number(3))
                    }
                )
                CalculatorButton(
                    symbol = "+",
                    modifier = Modifier
                        .background(MaterialTheme.colorScheme.tertiaryContainer)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CalculatorAction.Operation(CalculatorOperation.Add))
                    }
                )
            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
            ) {
                CalculatorButton(
                    symbol = "0",
                    modifier = Modifier
                        .background(MaterialTheme.colorScheme.onPrimary)
                        .aspectRatio(2f)
                        .weight(2f),
                    onClick = {
                        onAction(CalculatorAction.Number(0))
                    }
                )
                CalculatorButton(
                    symbol = ".",
                    modifier = Modifier
                        .background(MaterialTheme.colorScheme.secondaryContainer)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CalculatorAction.Decimal)
                    }
                )
                CalculatorButton(
                    symbol = "=",
                    modifier = Modifier
                        .background(MaterialTheme.colorScheme.tertiaryContainer)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CalculatorAction.Calulate)
                    }
                )

            }
        }
    }
}
